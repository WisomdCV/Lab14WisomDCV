package com.example.myapplication

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.*
import androidx.glance.action.ActionParameters
import androidx.glance.action.actionParametersOf
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.*
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import androidx.glance.Image
import androidx.glance.action.clickable
import java.text.SimpleDateFormat
import java.util.*

class SimpleWidgetContent : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                CustomWidgetContent()
            }
        }
    }

    companion object {
        val DestinationKey = ActionParameters.Key<String>("destination")
    }

    // Función para obtener la hora actual en formato de texto
    private fun getCurrentTime(): String {
        val currentTime = Calendar.getInstance().time
        val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())
        return formatter.format(currentTime)
    }

    @Composable
    private fun CustomWidgetContent() {
        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(ColorProvider(Color.Black))
                .padding(16.dp),
            verticalAlignment = Alignment.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Mostrar la hora actual
            Text(
                text = "Hora: ${getCurrentTime()}",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = ColorProvider(Color.White)
                ),
                modifier = GlanceModifier.padding(bottom = 8.dp)
            )

            Text(
                text = "Accesos Rápidos",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = ColorProvider(Color(0xFF39FF14))
                ),
                modifier = GlanceModifier.padding(bottom = 8.dp)
            )

            Row(horizontalAlignment = Alignment.CenterHorizontally) {
                Column(
                    modifier = GlanceModifier
                        .padding(8.dp)
                        .clickable(
                            onClick = actionStartActivity<MainActivity>(
                                actionParametersOf(DestinationKey to "main")
                            )
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        provider = ImageProvider(R.drawable.psyduck),
                        contentDescription = "Icono de Principal",
                        modifier = GlanceModifier.size(32.dp)
                    )
                    Spacer(modifier = GlanceModifier.height(4.dp))
                    Text(
                        text = "Principal",
                        style = TextStyle(fontSize = 14.sp, color = ColorProvider(Color.White))
                    )
                }

                Spacer(modifier = GlanceModifier.width(16.dp))

                Column(
                    modifier = GlanceModifier
                        .padding(8.dp)
                        .clickable(
                            onClick = actionStartActivity<MainActivity>(
                                actionParametersOf(DestinationKey to "second")
                            )
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        provider = ImageProvider(R.drawable.ic_launcher_foreground),
                        contentDescription = "Icono de Info",
                        modifier = GlanceModifier.size(32.dp)
                    )
                    Spacer(modifier = GlanceModifier.height(4.dp))
                    Text(
                        text = "Info",
                        style = TextStyle(fontSize = 14.sp, color = ColorProvider(Color.White))
                    )
                }
            }
        }
    }
}
