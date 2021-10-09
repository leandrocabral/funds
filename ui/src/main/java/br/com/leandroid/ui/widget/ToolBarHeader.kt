package br.com.leandroid.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import br.com.leandroid.ui.R

class ToolbarHeaderView
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val title: TextView?
    private val arrowBack: ImageView?
    val search: ImageView?
    val editSearch: EditText?

    init {
        inflate(context, R.layout.toolbar_header_widget, this)
        title = findViewById(R.id.title_toolbar_header)
        arrowBack = findViewById(R.id.arrow_toolbar_header)
        search = findViewById(R.id.search_toolbar_header)
        editSearch = findViewById(R.id.edit_search_toolbar_header)
        setAttribute(attrs)
        setupView()
    }

    private fun setupView() {
        search?.setOnClickListener {
            if (editSearch?.isVisible == true) {
                editSearch.visibility = View.GONE
                title?.visibility = View.VISIBLE
            } else {
                editSearch?.visibility = View.VISIBLE
                title?.visibility = View.GONE
            }
        }
    }

    private fun setType(type: String?) {
        when (type) {
            TYPE_SEARCH -> {
                search?.visibility = View.VISIBLE
            }
            else -> {
                arrowBack?.visibility = View.VISIBLE
            }
        }
    }

    private fun setAttribute(attrs: AttributeSet?) {
        val attributeSet = context.obtainStyledAttributes(attrs, R.styleable.ToolbarHeaderWidget)
        val type = attributeSet.getString(R.styleable.ToolbarHeaderWidget_type)
        title?.text = attributeSet.getString(R.styleable.ToolbarHeaderWidget_title)
        setType(type)
        attributeSet.recycle()
    }

    companion object {
        const val TYPE_SEARCH = "1"
    }
}