package ca.tremblay95.mycityapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ca.tremblay95.mycityapp.R

val Allan = FontFamily(
    Font(R.font.allan_regular),
    Font(R.font.allan_bold, FontWeight.Bold)
)
val Alef = FontFamily(
    Font(R.font.alef_regular),
    Font(R.font.alef_bold, FontWeight.Bold)
)

val baseline = Typography()

// Set of Material typography styles to start with
val Typography = Typography(
    /*displayLarge = TextStyle(
        fontFamily = Allan,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Allan,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Alef,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Alef,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    )*/
    displayLarge = baseline.displayLarge.copy(fontFamily = Allan),
    displayMedium = baseline.displayMedium.copy(fontFamily = Allan),
    displaySmall = baseline.displaySmall.copy(fontFamily = Allan),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = Allan),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = Allan),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = Allan),
    titleLarge = baseline.titleLarge.copy(fontFamily = Allan),
    titleMedium = baseline.titleMedium.copy(fontFamily = Allan),
    titleSmall = baseline.titleSmall.copy(fontFamily = Allan),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = Alef),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = Alef),
    bodySmall = baseline.bodySmall.copy(fontFamily = Alef),
    labelLarge = baseline.labelLarge.copy(fontFamily = Alef),
    labelMedium = baseline.labelMedium.copy(fontFamily = Alef),
    labelSmall = baseline.labelSmall.copy(fontFamily = Alef),
)   