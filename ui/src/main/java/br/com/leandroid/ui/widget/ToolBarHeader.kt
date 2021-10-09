package br.com.leandroid.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.leandroid.ui.R

class ToolbarHeaderView
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val title: TextView?

    init {
        inflate(context, R.layout.toolbar_header_widget, this)
        title = findViewById(R.id.title_toolbar_header)
        setAttribute(attrs)
    }

    fun setType(type: String?) {

    }

    private fun setAttribute(attrs: AttributeSet?) {
        val attributeSet = context.obtainStyledAttributes(attrs, R.styleable.ToolbarHeaderWidget)
        title?.text = attributeSet.getString(R.styleable.ToolbarHeaderWidget_title)
        attributeSet.recycle()
    }
}