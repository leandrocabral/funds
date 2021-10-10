package br.com.leandroid.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.leandroid.ui.R

class CardFunds
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val name: TextView?
    private val strategy: TextView?
    private val type: TextView?

    init {
        inflate(context, R.layout.card_funds_widget, this)
        name = findViewById(R.id.name_card_funds)
        strategy = findViewById(R.id.strategy_card_funds)
        type = findViewById(R.id.type_card_funds)
        setAttribute(attrs)
    }

    fun setName(text: String?) {
        name?.text = text
    }

    fun setStrategy(text: String?) {
        strategy?.text = text
    }

    fun setType(text: String?) {
        type?.text = text
    }

    private fun setAttribute(attrs: AttributeSet?) {
        val attributeSet = context.obtainStyledAttributes(attrs, R.styleable.CardFundsWidget)
        name?.text = attributeSet.getString(R.styleable.CardFundsWidget_name)
        strategy?.text = attributeSet.getString(R.styleable.CardFundsWidget_strategy)
        type?.text = attributeSet.getString(R.styleable.CardFundsWidget_typeFund)
        attributeSet.recycle()
    }
}