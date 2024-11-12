package com.example.myapplication

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.action.ActionParameters
import androidx.glance.action.actionParametersOf
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider

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

    @Composable
    private fun CustomWidgetContent() {
        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(GlanceTheme.colors.background)
                .padding(16.dp),
            verticalAlignment = Alignment.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
                Button(
                    text = "Principal",
                    modifier = GlanceModifier.padding(8.dp),
                    onClick = actionStartActivity<MainActivity>(
                        actionParametersOf(DestinationKey to "main")
                    )
                )

                Spacer(modifier = GlanceModifier.padding(horizontal = 8.dp))

                Button(
                    text = "Info",
                    modifier = GlanceModifier.padding(8.dp),
                    onClick = actionStartActivity<MainActivity>(
                        actionParametersOf(DestinationKey to "second")
                    )
                )
            }

        }
    }
}
