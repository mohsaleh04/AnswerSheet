package ir.saltech.answersheet.ui.view

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusChanged
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
import ir.saltech.answersheet.App
import ir.saltech.answersheet.R
import ir.saltech.answersheet.dto.models.Document
import ir.saltech.answersheet.dto.models.ExamName
import ir.saltech.answersheet.dto.models.testExamNames
import ir.saltech.answersheet.ui.states.rememberPickerState
import ir.saltech.answersheet.ui.theme.AnswerSheetTheme
import ir.saltech.answersheet.utils.checkExamTimeValidation
import ir.saltech.answersheet.utils.pow
import ir.saltech.answersheet.utils.toStringList
import ir.saltech.answersheet.viewmodels.MainViewModel


const val MAX_QUESTION_NUMBER_LENGTH: Int = 6

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewExamPage(
    padding: PaddingValues = PaddingValues(0.dp),
    mainViewModel: MainViewModel = viewModel()
) {
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
    var examName: ExamName? by remember { mutableStateOf(null) }
    var examDocument: Document? by remember { mutableStateOf(null) }

    var examNameSelectionWanted by remember { mutableStateOf(false) }

    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
            if (uri != null) {
                val docName = Uri.parse("file://${uri.path}").toFile().name
                val document = mainViewModel.saveDocumentFile(
                    bytes =
                    mainViewModel.context.contentResolver.openInputStream(uri)?.readBytes()
                        ?: return@rememberLauncherForActivityResult,
                    name = docName
                )
                examDocument = Document(id = docName, file = document)
            }
        }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        Column {
            TitleBar(
                modifier = Modifier.padding(vertical = 16.dp), title = "آزمون جدید", showBack = true
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
                        FilledToggleButton(checked = examDocument != null, onCheckedChanged = {
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
                        FilledToggleButton(checked = examName != null, onCheckedChanged = {
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
                            }).padding(top = 13.dp, bottom = 5.dp, start = 5.dp, end = 5.dp),
                            enabled = (questionsCountFrom != 0) and (questionsCountTo != 0) and (questionsCountTo - questionsCountFrom >= 5),
                            checked = questionsCountShuffle,
                            onCheckedChange = {
                                questionsCountShuffle = !questionsCountShuffle
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
                                    questionsCount = if ((it.length in 1..3) and ((it.toIntOrNull()
                                            ?: 0) in 1..500)
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
                                textStyle = MaterialTheme.typography.bodyLarge.copy(textAlign = TextAlign.Center),
                                shape = RoundedCornerShape(15.dp),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number, imeAction = ImeAction.Done
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
                                    questionsCountRatio =
                                        if ((it.length in 1..2) and ((it.toIntOrNull()
                                                ?: 0) in 1..20)
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
                                textStyle = MaterialTheme.typography.bodyLarge.copy(textAlign = TextAlign.Center),
                                shape = RoundedCornerShape(15.dp),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number, imeAction = ImeAction.Done
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
                            textStyle = MaterialTheme.typography.bodyLarge.copy(textAlign = TextAlign.Center),
                            shape = RoundedCornerShape(15.dp),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number, imeAction = ImeAction.Next
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
                                            ?: 0) in 1..<(10 pow (MAX_QUESTION_NUMBER_LENGTH + 1)))
                                    ) {
                                        if (questionsCountRatio == 0) questionsCountRatio = 1
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
                            textStyle = MaterialTheme.typography.bodyLarge.copy(textAlign = TextAlign.Center),
                            shape = RoundedCornerShape(15.dp),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number, imeAction = ImeAction.Next
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
                                onClick = { examCorrectionMode = App.ExamCorrectionMode.ByKeys },
                                shape = RoundedCornerShape(topStart = 100.dp, bottomStart = 100.dp)
                            ) {
                                Text("با کلید")
                            }
                            SegmentedButton(
                                selected = examCorrectionMode == App.ExamCorrectionMode.Manual,
                                onClick = { examCorrectionMode = App.ExamCorrectionMode.Manual },
                                shape = RoundedCornerShape(0)
                            ) {
                                Text("دستی")
                            }
                            SegmentedButton(
                                selected = examCorrectionMode == App.ExamCorrectionMode.None,
                                onClick = { examCorrectionMode = App.ExamCorrectionMode.None },
                                shape = RoundedCornerShape(topEnd = 100.dp, bottomEnd = 100.dp)
                            ) {
                                Text("هیچ")
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
                                        examTimeHourState.selectedItem.toIntOrNull() ?: 0,
                                        examTimeMinuteState.selectedItem.toIntOrNull() ?: 0
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
                Button(modifier = Modifier.fillMaxWidth(0.8f), onClick = { /*TODO*/ }) {
                    Text(
                        "ورود به اتاق آزمون",
                        style = LocalTextStyle.current.copy(fontWeight = FontWeight.Bold)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                FilledIconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.exam_schedule),
                        contentDescription = "Schedule Exam"
                    )
                }
            }
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExamNameSelection(
    examName: ExamName? = null, onDismissRequest: () -> Unit, onExamNameSelected: (ExamName) -> Unit
) {
    ModalBottomSheet(onDismissRequest = onDismissRequest) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "انتخاب کنید", style = MaterialTheme.typography.displayMedium)
            Spacer(modifier = Modifier.height(16.dp))
            LockedDirection(LayoutDirection.Rtl) {
                LazyVerticalGrid(columns = GridCells.Adaptive(100.dp)) {
                    items(testExamNames) {
                        if (it == examName) {
                            Button(modifier = Modifier
                                .padding(vertical = 8.dp, horizontal = 8.dp)
                                .clickable(false) {}, onClick = { /* Do nothing */ }) {
                                Text(text = it.name)
                            }
                        } else {
                            FilledTonalButton(modifier = Modifier.padding(
                                vertical = 8.dp, horizontal = 8.dp
                            ), onClick = { onExamNameSelected(it); onDismissRequest() }) {
                                Text(text = it.name, color = MaterialTheme.colorScheme.primary)
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewExamPagePreview() {
    AnswerSheetTheme {
        NewExamPage()
    }
}
