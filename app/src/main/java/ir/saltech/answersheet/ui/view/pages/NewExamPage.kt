package ir.saltech.answersheet.ui.view.pages

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toFile
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gmail.hamedvakhide.compose_jalali_datepicker.JalaliDatePickerDialog
import ir.huri.jcal.JalaliCalendar
import ir.saltech.answersheet.App
import ir.saltech.answersheet.R
import ir.saltech.answersheet.dto.models.Document
import ir.saltech.answersheet.dto.models.Exam
import ir.saltech.answersheet.dto.models.ExamChronometer
import ir.saltech.answersheet.dto.models.ExamName
import ir.saltech.answersheet.dto.models.ExamTime
import ir.saltech.answersheet.dto.models.ExamWhen
import ir.saltech.answersheet.dto.models.Exams
import ir.saltech.answersheet.dto.models.Question
import ir.saltech.answersheet.dto.models.Questions
import ir.saltech.answersheet.dto.models.QuestionsRange
import ir.saltech.answersheet.ui.states.rememberPickerState
import ir.saltech.answersheet.ui.theme.AnswerSheetTheme
import ir.saltech.answersheet.ui.view.ExamNameSelection
import ir.saltech.answersheet.ui.view.FilledToggleButton
import ir.saltech.answersheet.ui.view.GroupBox
import ir.saltech.answersheet.ui.view.LockedDirection
import ir.saltech.answersheet.ui.view.MaterialAlertDialog
import ir.saltech.answersheet.ui.view.Picker
import ir.saltech.answersheet.ui.view.TimeSelection
import ir.saltech.answersheet.ui.view.TitleBar
import ir.saltech.answersheet.utils.checkExamTimeValidation
import ir.saltech.answersheet.utils.pow
import ir.saltech.answersheet.utils.toStringList
import ir.saltech.answersheet.viewmodels.MainViewModel
import kotlinx.coroutines.launch
import java.util.Date
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.random.nextLong


const val MAX_QUESTION_NUMBER_LENGTH: Int = 6
const val MIN_OF_QUESTIONS: Int = 5

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewExamPage(
    mainViewModel: MainViewModel = viewModel(), onPageChanged: (App.Page) -> Unit
) {
    val answerSheetState by mainViewModel.uiState.collectAsState()
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }
    val focus = LocalFocusManager.current

    val examTimeHourState = rememberPickerState()
    val examTimeMinuteState = rememberPickerState()
    val examChronoThresholdState = rememberPickerState()

    var questionsCountFrom by remember { mutableIntStateOf(0) }
    var questionsCountTo by remember { mutableIntStateOf(0) }
    var questionsCountRatio by remember { mutableIntStateOf(0) }
    var questionsCount by remember { mutableIntStateOf(0) }
    var questionsCountRatioFocused by remember { mutableStateOf(false) }
    var questionsCountShuffle by remember { mutableStateOf(false) }
    var examCorrectionMode by remember { mutableStateOf(App.ExamCorrectionMode.None) }
    var examChronoEnabled by remember { mutableStateOf(false) }
    var examCategoryEnabled by remember { mutableStateOf(false) }
    var examCategoryTimingEnabled by remember { mutableStateOf(false) }
    var examCategoryCorrectionEnabled by remember { mutableStateOf(false) }
    var examCorrectionWithNegativePoint by remember { mutableStateOf(false) }
    var examScheduleSelectedJalaliCalendar by remember { mutableStateOf<JalaliCalendar?>(null) }
    var examScheduleSelectedDate by remember { mutableStateOf<Date?>(null) }
    var examScheduledSucceed by remember { mutableStateOf(false) }
    var examName by remember { mutableStateOf<ExamName?>(null) }
    var examDocument by remember { mutableStateOf<Document?>(null) }
    var examDescription by remember { mutableStateOf<String?>(null) }

    var examNameSelectionWanted by remember { mutableStateOf(false) }
    var examScheduleSelectionTimeWanted by remember { mutableStateOf(false) }
    val examScheduleSelectionDateWanted = remember { mutableStateOf(false) }

    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
            if (uri != null) {
                val docName = Uri.parse("file://${uri.path}").toFile().name
                val document = mainViewModel.saveDocumentFile(
                    bytes = mainViewModel.context.contentResolver.openInputStream(uri)?.readBytes()
                        ?: return@rememberLauncherForActivityResult, name = docName
                )
                examDocument = Document(id = docName, file = document)
            }
        }
    val checkExam = fun(): Pair<Boolean, String?> {
        val error: String?

        if (examName == null) {
            error = "نام آزمون را انتخاب کنید."
            return Pair(false, error)
        }

        if (examTimeMinuteState.selectedItem != "0" || examTimeHourState.selectedItem != "0") {
            if (!checkExamTimeValidation(
                    examTimeHourState.selectedItem.toIntOrNull() ?: 0,
                    examTimeMinuteState.selectedItem.toIntOrNull() ?: 0
                )
            ) {
                error = "زمان آزمون دچار اشکال است!"
                return Pair(false, error)
            }
        }

        if (questionsCountTo > 0) {
            if (!(questionsCountFrom > 0 && questionsCountTo - questionsCountFrom >= MIN_OF_QUESTIONS)) {
                error = "آخرین سؤال آزمون باید حداقل $MIN_OF_QUESTIONS تا از آخرین سؤال بیشتر باشد!"
                return Pair(false, error)
            }
        }

        if (questionsCountFrom > 0) {
            if (!(questionsCountTo > 0 && questionsCountTo - questionsCountFrom >= MIN_OF_QUESTIONS)) {
                error = "اولین سؤال آزمون باید حداقل $MIN_OF_QUESTIONS تا از آخرین سؤال کمتر باشد!"
                return Pair(false, error)
            }

            if (questionsCountShuffle) {
                if (questionsCount == 0) questionsCount = MIN_OF_QUESTIONS
                questionsCountRatio = 1
                if (questionsCount !in MIN_OF_QUESTIONS..(questionsCountTo - questionsCountFrom)) {
                    error = "برای انتخاب تصادفی، حداقل تعداد $MIN_OF_QUESTIONS سؤال را انتخاب کنید."
                    return Pair(false, error)
                }
            } else {
                if (questionsCountRatio == 0) questionsCountRatio = 1
                questionsCount = questionsCountTo - questionsCountFrom
                if (questionsCountRatio !in 1..((questionsCountTo - questionsCountFrom) / MIN_OF_QUESTIONS)) {
                    error = "الگوی شمارش باید حداقل $MIN_OF_QUESTIONS سؤال را شامل شود."
                    return Pair(false, error)
                }
            }
        }
        return Pair(true, null)
    }
    val getExamQuestions = fun(): Questions? {
        if (questionsCountFrom > 0 && questionsCountTo > 0) {
            val examQuestionsRange = QuestionsRange(
                from = questionsCountFrom,
                to = questionsCountTo,
                count = questionsCount,
                step = questionsCountRatio,
                shuffle = questionsCountShuffle
            )
            val listQuestions = mutableSetOf<Question>()
            for (index in 0..questionsCount) {
                val questionNumber =
                    if (questionsCountShuffle) Random(
                        questionsCountFrom
                    ).nextInt(
                        questionsCountFrom..questionsCountTo
                    ) else questionsCountFrom + index
                val chronometer = if (examChronoEnabled && examChronoThresholdState.selectedItem != "0") ExamChronometer(threshold = examChronoThresholdState.selectedItem.toLong()) else null
                // TODO: Question features must be completed in the future. , such as category, chronometer and etc.
                val question = Question(number = questionNumber, chronometer = chronometer)
                listQuestions.add(question)
            }
            return Questions(
                listQuestions,
                examQuestionsRange,
                examCorrectionWithNegativePoint
            )
        } else {
            return null
        }
    }
    val getExamFeatures = fun(): List<App.ExamFeature>? {
        val examFeatures = mutableListOf<App.ExamFeature>()
        if ((examTimeMinuteState.selectedItem != "0" || examTimeHourState.selectedItem != "0") && checkExamTimeValidation(
                examTimeHourState.selectedItem.toIntOrNull() ?: 0,
                examTimeMinuteState.selectedItem.toIntOrNull() ?: 0
            )
        ) {
            examFeatures.add(App.ExamFeature.Timing)
        }
        if (examCorrectionMode != App.ExamCorrectionMode.None) {
            examFeatures.add(App.ExamFeature.Correction)
        }
        if (examChronoEnabled) {
            examFeatures.add(App.ExamFeature.Chronometer)
            if (examChronoThresholdState.selectedItem != "0") {
                examFeatures.add(App.ExamFeature.ChronometerThreshold)
            }
        }
        if (examCategoryEnabled) {
            examFeatures.add(App.ExamFeature.Categorization)
        }
        if (examCategoryTimingEnabled) {
            examFeatures.add(App.ExamFeature.CategoryTiming)
        }
        if (examCategoryCorrectionEnabled) {
            examFeatures.add(App.ExamFeature.CategoryCorrection)
        }
        return if (examFeatures.isNotEmpty()) {
            examFeatures.toList()
        } else {
            null
        }
    }
    val getExamTime = fun(): ExamTime? {
        if (examTimeMinuteState.selectedItem != "0" || examTimeHourState.selectedItem != "0") {
            val time =
                ((examTimeHourState.selectedItem.toLong() * 3_600) + (examTimeMinuteState.selectedItem.toLong() * 60)) * 1000
            return ExamTime(whole = time, left = time)
        } else {
            return null
        }
    }

    LockedDirection(LayoutDirection.Rtl) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            snackbarHost = {
                SnackbarHost(hostState = snackBarHostState)
            },
        ) { padding ->
            LockedDirection {
                Box (modifier = Modifier.padding(padding)) {
                    Column {
                        TitleBar(
                            modifier = Modifier.padding(vertical = 16.dp),
                            title = "آزمون جدید",
                            showBack = true
                        )
                        Column(
                            modifier = Modifier
                                .verticalScroll(rememberScrollState())
                                .padding(bottom = 64.dp)
                        ) {
                            Column {
                                Spacer(modifier = Modifier.height(13.dp))
                                LockedDirection(LayoutDirection.Rtl) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 8.dp, horizontal = 24.dp)
                                    ) {
                                        Icon(
                                            modifier = Modifier
                                                .width(28.dp)
                                                .height(28.dp),
                                            tint = MaterialTheme.colorScheme.primary,
                                            painter = painterResource(id = R.drawable.title_icon_exam_specs),
                                            contentDescription = ""
                                        )
                                        Spacer(modifier = Modifier.width(16.dp))
                                        Text(
                                            modifier = Modifier,
                                            text = "مشخصات آزمون",
                                            style = MaterialTheme.typography.bodyLarge.copy(
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 19.sp,
                                                color = MaterialTheme.colorScheme.primary
                                            )
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.padding(5.dp))
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp),
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    FilledToggleButton(checked = examDocument != null,
                                        onCheckedChanged = {
                                            //examDocumentSelectionWanted = true
                                            launcher.launch(arrayOf("application/pdf"))
                                        }) {
                                        Text(text = if (examDocument != null) "انتخاب شد" else "فایل سؤالات")
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Icon(
                                            painter = painterResource(id = R.drawable.exam_document_attach),
                                            contentDescription = "Exam Document Attachment"
                                        )
                                    }
                                    FilledToggleButton(checked = examName != null,
                                        onCheckedChanged = {
                                            examNameSelectionWanted = true
                                        }) {
                                        Text(text = if (examName != null) examName!!.name else " نام آزمون ")
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Icon(
                                            painter = painterResource(id = R.drawable.exam_name),
                                            contentDescription = "Exam Name"
                                        )
                                    }
                                }
                                LockedDirection(LayoutDirection.Rtl) {
                                    OutlinedTextField(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(horizontal = 32.dp, vertical = 8.dp),
                                        value = examDescription ?: "",
                                        onValueChange = {
                                            if (it.isNotEmpty() && it.length <= 200) {
                                                examDescription = it
                                            } else if (it.isEmpty()) {
                                                examDescription = null
                                            }
                                        },
                                        singleLine = true,
                                        label = { Text("شرح مختصر آزمون") },
                                        textStyle = MaterialTheme.typography.bodyLarge,
                                        shape = RoundedCornerShape(15.dp),
                                        keyboardOptions = KeyboardOptions(
                                            keyboardType = KeyboardType.Text,
                                            imeAction = ImeAction.Done
                                        ),
                                        keyboardActions = KeyboardActions(onDone = {
                                            focus.clearFocus(
                                                true
                                            )
                                        })
                                    )
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                            Column {
                                Spacer(modifier = Modifier.height(13.dp))
                                LockedDirection(LayoutDirection.Rtl) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 8.dp, horizontal = 24.dp)
                                    ) {
                                        Icon(
                                            modifier = Modifier
                                                .width(28.dp)
                                                .height(28.dp)
                                                .scale(1.05f),
                                            tint = MaterialTheme.colorScheme.primary,
                                            painter = painterResource(id = R.drawable.title_icon_exam_questions),
                                            contentDescription = ""
                                        )
                                        Spacer(modifier = Modifier.width(16.dp))
                                        Text(
                                            modifier = Modifier,
                                            text = "سؤالات آزمون",
                                            style = MaterialTheme.typography.bodyLarge.copy(
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 19.sp,
                                                color = MaterialTheme.colorScheme.primary
                                            )
                                        )
                                    }
                                }
                                LockedDirection(LayoutDirection.Rtl) {
                                    Text(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 5.dp, start = 24.dp, end = 24.dp),
                                        text = "در صورتی که می\u200Cخواهید به صورت دستی سؤالات را وارد کنید، این بخش را خالی رها کنید.",
                                        color = MaterialTheme.colorScheme.secondary
                                    )
                                }
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .fillMaxHeight()
                                        .padding(8.dp),
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    FilledIconToggleButton(
                                        modifier = (if (questionsCountRatioFocused || questionsCountRatio != 0) {
                                            Modifier.height(IntrinsicSize.Max)
                                        } else {
                                            Modifier.height(100.dp)
                                        }).padding(
                                            top = 13.dp, bottom = 5.dp, start = 5.dp, end = 5.dp
                                        ),
                                        enabled = (questionsCountFrom != 0) and (questionsCountTo != 0) and (questionsCountTo - questionsCountFrom >= MIN_OF_QUESTIONS),
                                        checked = questionsCountShuffle,
                                        onCheckedChange = {
                                            questionsCountShuffle = !questionsCountShuffle
                                            if (questionsCountShuffle) {
                                                questionsCountRatio = 1
                                            } else {
                                                questionsCount = 0
                                            }
                                        },
                                        shape = RoundedCornerShape(15.dp)
                                    ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.exam_questions_random_generation),
                                            contentDescription = "Shuffle questions"
                                        )
                                    }
                                    if (questionsCountShuffle) {
                                        OutlinedTextField(
                                            modifier = Modifier
                                                .weight(1f)
                                                .padding(8.dp)
                                                .onFocusChanged {
                                                    questionsCountRatioFocused = it.isFocused
                                                },
                                            enabled = questionsCountShuffle,
                                            value = "${if (questionsCount > 0) questionsCount else ""}",
                                            onValueChange = {
                                                questionsCount = if ((it.toIntOrNull()
                                                        ?: 0) in 1..(questionsCountTo - questionsCountFrom)
                                                ) {
                                                    it.toInt()
                                                } else {
                                                    0
                                                }
                                            },
                                            label = {
                                                Text(
                                                    "تعداد\nسؤال",
                                                    textAlign = TextAlign.Center,
                                                    modifier = Modifier.fillMaxWidth()
                                                )
                                            },
                                            singleLine = true,
                                            textStyle = MaterialTheme.typography.bodyLarge.copy(
                                                textAlign = TextAlign.Center
                                            ),
                                            shape = RoundedCornerShape(15.dp),
                                            keyboardOptions = KeyboardOptions(
                                                keyboardType = KeyboardType.Number,
                                                imeAction = ImeAction.Done
                                            ),
                                            keyboardActions = KeyboardActions(onDone = {
                                                focus.clearFocus(true)
                                            })
                                        )
                                    } else {
                                        OutlinedTextField(
                                            modifier = Modifier
                                                .weight(1f)
                                                .padding(8.dp)
                                                .onFocusChanged {
                                                    questionsCountRatioFocused = it.isFocused
                                                },
                                            enabled = !questionsCountShuffle,
                                            value = "${if (questionsCountRatio > 0) questionsCountRatio else ""}",
                                            onValueChange = {
                                                questionsCountRatio = if ((it.toIntOrNull()
                                                        ?: 0) in 1..((questionsCountTo - questionsCountFrom) / MIN_OF_QUESTIONS)
                                                ) {
                                                    it.toInt()
                                                } else {
                                                    0
                                                }
                                            },
                                            label = {
                                                Text(
                                                    "الگوی\nشمارش",
                                                    textAlign = TextAlign.Center,
                                                    modifier = Modifier.fillMaxWidth()
                                                )
                                            },
                                            singleLine = true,
                                            textStyle = MaterialTheme.typography.bodyLarge.copy(
                                                textAlign = TextAlign.Center
                                            ),
                                            shape = RoundedCornerShape(15.dp),
                                            keyboardOptions = KeyboardOptions(
                                                keyboardType = KeyboardType.Number,
                                                imeAction = ImeAction.Done
                                            ),
                                            keyboardActions = KeyboardActions(onDone = {
                                                focus.clearFocus(true)
                                            })
                                        )
                                    }
                                    OutlinedTextField(
                                        modifier = Modifier
                                            .weight(1f)
                                            .padding(8.dp),
                                        value = "${if (questionsCountTo > 0) questionsCountTo else ""}",
                                        onValueChange = {
                                            questionsCountTo =
                                                if (it.length in 1..MAX_QUESTION_NUMBER_LENGTH && (it.toIntOrNull()
                                                        ?: 0) in 1..<(10 pow (MAX_QUESTION_NUMBER_LENGTH + 1))
                                                ) {
                                                    it.toInt()
                                                } else {
                                                    0
                                                }
                                        },
                                        label = {
                                            Text(
                                                "تا\nسؤال",
                                                textAlign = TextAlign.Center,
                                                modifier = Modifier.fillMaxWidth()
                                            )
                                        },
                                        singleLine = true,
                                        textStyle = MaterialTheme.typography.bodyLarge.copy(
                                            textAlign = TextAlign.Center
                                        ),
                                        shape = RoundedCornerShape(15.dp),
                                        keyboardOptions = KeyboardOptions(
                                            keyboardType = KeyboardType.Number,
                                            imeAction = ImeAction.Next
                                        ),
                                        keyboardActions = KeyboardActions(onNext = {
                                            focus.moveFocus(FocusDirection.Left)
                                        })
                                    )
                                    OutlinedTextField(
                                        modifier = Modifier
                                            .weight(1f)
                                            .padding(8.dp),
                                        value = "${if (questionsCountFrom > 0) questionsCountFrom else ""}",
                                        onValueChange = {
                                            questionsCountFrom =
                                                if ((it.length in 1..MAX_QUESTION_NUMBER_LENGTH) and ((it.toIntOrNull()
                                                        ?: 0) in 1..<(if (questionsCountTo > 0) questionsCountTo - MIN_OF_QUESTIONS else (10 pow (MAX_QUESTION_NUMBER_LENGTH + 1))))
                                                ) {
                                                    if (questionsCountRatio == 0) questionsCountRatio =
                                                        1
                                                    it.toInt()
                                                } else {
                                                    questionsCountRatio = 0
                                                    0
                                                }
                                        },
                                        label = {
                                            Text(
                                                "از\nسؤال",
                                                textAlign = TextAlign.Center,
                                                modifier = Modifier.fillMaxWidth()
                                            )
                                        },
                                        singleLine = true,
                                        textStyle = MaterialTheme.typography.bodyLarge.copy(
                                            textAlign = TextAlign.Center
                                        ),
                                        shape = RoundedCornerShape(15.dp),
                                        keyboardOptions = KeyboardOptions(
                                            keyboardType = KeyboardType.Number,
                                            imeAction = ImeAction.Next
                                        ),
                                        keyboardActions = KeyboardActions(onNext = {
                                            focus.moveFocus(FocusDirection.Left)
                                        })
                                    )
                                }
                            }
                            Column {
                                Spacer(modifier = Modifier.height(13.dp))
                                LockedDirection(LayoutDirection.Rtl) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 8.dp, horizontal = 24.dp)
                                    ) {
                                        Icon(
                                            modifier = Modifier
                                                .width(28.dp)
                                                .height(28.dp)
                                                .scale(1.05f),
                                            tint = MaterialTheme.colorScheme.primary,
                                            painter = painterResource(id = R.drawable.title_icon_exam_features),
                                            contentDescription = ""
                                        )
                                        Spacer(modifier = Modifier.width(16.dp))
                                        Text(
                                            modifier = Modifier,
                                            text = "قابلیت\u200Cهای آزمون",
                                            style = MaterialTheme.typography.bodyLarge.copy(
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 19.sp,
                                                color = MaterialTheme.colorScheme.primary
                                            )
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(16.dp))
                                Column(modifier = Modifier.fillMaxWidth()) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text("نحوه تصحیح آزمون")
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Icon(
                                            painter = painterResource(id = R.drawable.exam_correction),
                                            contentDescription = "Exam Correction"
                                        )
                                    }
                                    SingleChoiceSegmentedButtonRow(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 13.dp, horizontal = 24.dp)
                                    ) {
                                        SegmentedButton(
                                            selected = examCorrectionMode == App.ExamCorrectionMode.ByKeys,
                                            onClick = {
                                                examCorrectionMode = App.ExamCorrectionMode.ByKeys
                                            },
                                            shape = RoundedCornerShape(
                                                topStart = 100.dp, bottomStart = 100.dp
                                            )
                                        ) {
                                            Text("با کلید")
                                        }
                                        SegmentedButton(
                                            selected = examCorrectionMode == App.ExamCorrectionMode.Manual,
                                            onClick = {
                                                examCorrectionMode = App.ExamCorrectionMode.Manual
                                            },
                                            shape = RoundedCornerShape(0)
                                        ) {
                                            Text("دستی")
                                        }
                                        SegmentedButton(
                                            selected = examCorrectionMode == App.ExamCorrectionMode.None,
                                            onClick = {
                                                examCorrectionMode = App.ExamCorrectionMode.None
                                            },
                                            shape = RoundedCornerShape(
                                                topEnd = 100.dp, bottomEnd = 100.dp
                                            )
                                        ) {
                                            Text("هیچ")
                                        }
                                    }
                                    AnimatedVisibility(examCorrectionMode != App.ExamCorrectionMode.None) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(horizontal = 24.dp, vertical = 8.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Switch(
                                                checked = examCorrectionWithNegativePoint,
                                                onCheckedChange = {
                                                    examCorrectionWithNegativePoint = it
                                                })
                                            Text(
                                                modifier = Modifier.weight(1f),
                                                text = "لحاظ کردن نمره منفی",
                                                textAlign = TextAlign.End,
                                                style = MaterialTheme.typography.bodyLarge.copy(
                                                    fontSize = 18.sp
                                                )
                                            )
                                        }
                                    }
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                                GroupBox(modifier = Modifier.padding(horizontal = 10.dp),
                                    title = "زمان بندی آزمون",
                                    icon = {
                                        Icon(
                                            painter = painterResource(id = R.drawable.exam_time),
                                            contentDescription = "Exam Time"
                                        )
                                    }) {
                                    LockedDirection(LayoutDirection.Rtl) {
                                        Text(
                                            modifier = Modifier
                                                .padding(8.dp)
                                                .align(Alignment.CenterHorizontally),
                                            text = "در صورت عدم نیاز، این بخش را خالی رها کنید.",
                                            textAlign = TextAlign.Start,
                                            color = MaterialTheme.colorScheme.secondary
                                        )
                                    }
                                    Column(
                                        modifier = Modifier.padding(horizontal = 16.dp),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Text(
                                            text = "حداقل زمان آزمون: 00:05",
                                            color = MaterialTheme.colorScheme.tertiary
                                        )
                                        Spacer(modifier = Modifier.height(16.dp))
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(
                                                modifier = Modifier.weight(1f),
                                                text = "ساعت",
                                                textAlign = TextAlign.Center
                                            )
                                            Text(
                                                modifier = Modifier.weight(1f),
                                                text = "دقیقه",
                                                textAlign = TextAlign.Center
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Picker(
                                                modifier = Modifier.weight(1f),
                                                state = examTimeHourState,
                                                items = (0..5).toStringList()
                                            )
                                            Text(":", style = MaterialTheme.typography.displaySmall)
                                            Picker(
                                                modifier = Modifier.weight(1f),
                                                state = examTimeMinuteState,
                                                items = (0..<60).toStringList()
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(8.dp))
                                    }
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                                GroupBox(modifier = Modifier.padding(horizontal = 10.dp),
                                    title = "کرنومتر آزمون",
                                    icon = {
                                        Icon(
                                            painter = painterResource(id = R.drawable.exam_chronometer),
                                            contentDescription = "Exam Chronometer"
                                        )
                                    }) {
                                    LockedDirection(LayoutDirection.Rtl) {
                                        Text(
                                            modifier = Modifier
                                                .padding(8.dp)
                                                .align(Alignment.CenterHorizontally),
                                            text = "به کمک کرنومتر بفهمید هر تست را چند ثانیه می زنید.",
                                            textAlign = TextAlign.Start,
                                            color = MaterialTheme.colorScheme.secondary
                                        )
                                        FilledToggleButton(modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 8.dp, horizontal = 16.dp),
                                            checked = examChronoEnabled,
                                            onCheckedChanged = { examChronoEnabled = it }) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.exam_chronometer),
                                                contentDescription = "Enable Chronometer"
                                            )
                                            Spacer(modifier = Modifier.padding(8.dp))
                                            Text("فعال کردن کرنومتر")
                                        }
                                        Spacer(modifier = Modifier.height(8.dp))
                                        AnimatedVisibility(visible = examChronoEnabled) {
                                            Row(
                                                modifier = Modifier.padding(8.dp),
                                                horizontalArrangement = Arrangement.Center,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    modifier = Modifier.weight(0.75f),
                                                    text = "حداکثر زمان مجاز حل تست: (حسب ثانیه)"
                                                )
                                                Spacer(modifier = Modifier.width(8.dp))
                                                Picker(
                                                    modifier = Modifier.weight(1f),
                                                    state = examChronoThresholdState,
                                                    items = (0..100).toStringList()
                                                )
                                            }
                                        }
                                    }
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                                GroupBox(modifier = Modifier.padding(horizontal = 10.dp),
                                    title = "دسته بندی آزمون",
                                    icon = {
                                        Icon(
                                            painter = painterResource(id = R.drawable.exam_category),
                                            contentDescription = "Exam Category"
                                        )
                                    }) {
                                    FilledToggleButton(modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 8.dp, horizontal = 16.dp),
                                        checked = examCategoryEnabled,
                                        onCheckedChanged = { examCategoryEnabled = it }) {
                                        Text("فعال کردن دسته بندی")
                                        Spacer(modifier = Modifier.padding(8.dp))
                                        Icon(
                                            painter = painterResource(id = R.drawable.exam_category),
                                            contentDescription = "Enable Categorization"
                                        )
                                    }
                                    AnimatedVisibility(visible = examCategoryEnabled) {
                                        Column(
                                            modifier = Modifier.padding(
                                                vertical = 5.dp, horizontal = 10.dp
                                            )
                                        ) {
                                            FilledToggleButton(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(vertical = 8.dp, horizontal = 16.dp),
                                                checked = examCategoryTimingEnabled,
                                                onCheckedChanged = {
                                                    examCategoryTimingEnabled = it
                                                },
                                                enabled = checkExamTimeValidation(
                                                    examTimeHourState.selectedItem.toIntOrNull()
                                                        ?: 0,
                                                    examTimeMinuteState.selectedItem.toIntOrNull()
                                                        ?: 0
                                                )
                                            ) {
                                                Text("تعیین زمان مجزا دسته")
                                                Spacer(modifier = Modifier.padding(8.dp))
                                                Icon(
                                                    painter = painterResource(id = R.drawable.exam_category_time_enable),
                                                    contentDescription = "Enable Category Timing"
                                                )
                                            }
                                            FilledToggleButton(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(vertical = 8.dp, horizontal = 16.dp),
                                                checked = examCategoryCorrectionEnabled,
                                                onCheckedChanged = {
                                                    examCategoryCorrectionEnabled = it
                                                },
                                                enabled = examCorrectionMode != App.ExamCorrectionMode.None
                                            ) {
                                                Text("تصحیح مجزا دسته")
                                                Spacer(modifier = Modifier.padding(8.dp))
                                                Icon(
                                                    painter = painterResource(id = R.drawable.exam_correction_category),
                                                    contentDescription = "Enable Category Correction"
                                                )
                                            }
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(3.dp))
                                }
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .background(color = MaterialTheme.colorScheme.background.copy(alpha = 0.9f))
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            modifier = Modifier.padding(vertical = 10.dp, horizontal = 16.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Button(
                                modifier = Modifier.fillMaxWidth(0.8f),
                                enabled = !examScheduledSucceed,
                                onClick = {
                                    val (result, error) = checkExam()
                                    if (result) {
                                        val examTime: ExamTime? = getExamTime()
                                        val examFeatures = getExamFeatures()
                                        val examQuestions = getExamQuestions()
                                        val exam = Exam(
                                            id = Random(102192124).nextLong(100_000_000L..1_000_000_000L),
                                            name = examName ?: return@Button,
                                            document = examDocument,
                                            features = examFeatures,
                                            time = examTime,
                                            correctionMode = examCorrectionMode,
                                            questions = examQuestions,
                                            description = examDescription
                                        )
                                        val list = (answerSheetState.exams ?: Exams()).list
                                        list.add(exam)
                                        mainViewModel.exams = Exams(list)
                                        mainViewModel.currentExam = exam
                                        onPageChanged(App.Page.ExamRoom)
                                    } else {
                                        scope.launch {
                                            snackBarHostState.showSnackbar(
                                                "لطفاً خطای زیر را برطرف کنید:\n$error",
                                                withDismissAction = true
                                            )
                                        }
                                    }
                                }) {
                                Text(
                                    "ورود به اتاق آزمون",
                                    style = LocalTextStyle.current.copy(fontWeight = FontWeight.Bold)
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            FilledIconButton(onClick = {
                                val (result, error) = checkExam()
                                if (result) {
                                    examScheduleSelectionDateWanted.value = true
                                } else {
                                    scope.launch {
                                        snackBarHostState.showSnackbar(
                                            "لطفاً خطای زیر را برطرف کنید:\n$error",
                                            withDismissAction = true
                                        )
                                    }
                                }
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.exam_schedule),
                                    contentDescription = "Schedule Exam"
                                )
                            }
                        }
                    }
                }
            }
            Box {
                LockedDirection(LayoutDirection.Ltr) {
                    JalaliDatePickerDialog(
                        examScheduleSelectionDateWanted,
                        onConfirm = {
                            if (examScheduleSelectedDate != null)
                                examScheduleSelectionTimeWanted = true
                            else
                                examScheduleSelectionDateWanted.value = true
                        },
                        onSelectDay = { calendar ->
                            val currentDate = JalaliCalendar(Date())
                            if (calendar.toGregorian()
                                    .after(currentDate.toGregorian()) || calendar.toGregorian()
                                    .equals(currentDate.toGregorian())
                            ) {
                                examScheduleSelectedJalaliCalendar = calendar
                                examScheduleSelectedDate = calendar.toGregorian().time
                            } else {
                                scope.launch {
                                    snackBarHostState.showSnackbar("تاریخ شروع آزمون را درست انتخاب کنید.")
                                }
                            }
                        },
                        backgroundColor = MaterialTheme.colorScheme.surfaceContainer
                    )
                }
                TimeSelection(
                    visibility = examScheduleSelectionTimeWanted,
                    padding = padding,
                    onDismissRequested = { examScheduleSelectionTimeWanted = false },
                    onConfirmRequest = { timeState ->
                        if (examScheduleSelectedDate != null) {
                            examScheduleSelectionTimeWanted = false
                            examScheduledSucceed = true
                            examScheduleSelectedDate =
                                Date(examScheduleSelectedDate!!.time + (timeState.hour.toLong() * 3_600_000) + (timeState.minute.toLong() * 60_000))
                        }
                    }
                )
            }
            if (!examScheduleSelectionTimeWanted && !examScheduleSelectionDateWanted.value && examScheduledSucceed && examScheduleSelectedDate != null) {
                MaterialAlertDialog(
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.exam_schedule_bold),
                            contentDescription = "Exam Schedule"
                        )
                    },
                    title = "تأیید زمان بندی",
                    message = "آیا این زمان بندی \n${examScheduleSelectedDate} برای آزمون ${examName?.name} مورد پذیرش است؟",
                    confirmText = "بله",
                    onConfirm = {
                        val examSchedule = ExamWhen(scheduled = examScheduleSelectedDate)
                        val examTime: ExamTime? = getExamTime()
                        val examFeatures = getExamFeatures()
                        val examQuestions = getExamQuestions()
                        val exam = Exam(
                            id = Random(102192124).nextLong(100_000_000L..1_000_000_000L),
                            name = examName ?: return@MaterialAlertDialog,
                            status = App.ExamStatus.Scheduled,
                            document = examDocument,
                            features = examFeatures,
                            time = examTime,
                            correctionMode = examCorrectionMode,
                            questions = examQuestions,
                            whenn = examSchedule,
                            description = examDescription
                        )
                        val list = (answerSheetState.exams ?: Exams()).list
                        list.add(exam)
                        mainViewModel.exams = Exams(list)
                        Toast.makeText(
                            mainViewModel.context,
                            "آزمون زمانبندی شد.",
                            Toast.LENGTH_SHORT
                        ).show()
                        onPageChanged(App.Page.Home)
                    },
                    onDismiss = {
                        examScheduleSelectedDate = null
                        examScheduledSucceed = false
                    }
                )
            }
            if (examNameSelectionWanted) {
                ExamNameSelection(examName = examName, onDismissRequest = {
                    examNameSelectionWanted = false
                }) {
                    examName = it
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TimeSelectionPreview() {
    AnswerSheetTheme {
        TimeSelection(
            true,
            onDismissRequested = { },
            onConfirmRequest = { })
    }
}

@Preview
@Composable
fun NewExamPagePreview() {
    AnswerSheetTheme {
        NewExamPage {

        }
    }
}
