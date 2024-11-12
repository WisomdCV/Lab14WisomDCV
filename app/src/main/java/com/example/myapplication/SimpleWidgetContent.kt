package com.example.myapplication

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
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
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.Text
import androidx.glance.text.TextStyle

class SimpleWidgetContent : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                MyContent()
            }
        }
    }
    
    companion object {
        val DestinationKey = ActionParameters.Key<String>("destination")
    }

    @Composable
    private fun MyContent() {
        Column(
            modifier = GlanceModifier.fillMaxSize()
                .background(GlanceTheme.colors.background),
            verticalAlignment = Alignment.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "¿A dónde quieres dirigirte?",
                modifier = GlanceModifier.padding(12.dp),
                style = TextStyle(color = GlanceTheme.colors.primary)
            )
            Row(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    text = "Página Principal",
                    onClick = actionStartActivity<MainActivity>(
                        actionParametersOf(DestinationKey to "main")
                    )
                )
                Button(
                    text = "Segunda Vista",
                    onClick = actionStartActivity<MainActivity>(
                        actionParametersOf(DestinationKey to "second")
                    )
                )
            }
        }
    }
}
