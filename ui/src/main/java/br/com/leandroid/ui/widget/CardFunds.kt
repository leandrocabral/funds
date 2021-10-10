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
    private val descriptionStrategy: TextView?
    private val mininumValue: TextView?
    private val percent: TextView?

    init {
        inflate(context, R.layout.card_funds_widget, this)
        name = findViewById(R.id.name_card_funds)
        strategy = findViewById(R.id.strategy_card_funds)
        descriptionStrategy = findViewById(R.id.description_strategy_card_funds)
        mininumValue = findViewById(R.id.mininum_value_card_funds)
        percent = findViewById(R.id.percent_card_funds)
        setAttribute(attrs)
    }

    fun setName(text:String?){
        name?.text = text
    }

    private fun setAttribute(attrs: AttributeSet?) {
        val attributeSet = context.obtainStyledAttributes(attrs, R.styleable.CardFundsWidget)
        name?.text = attributeSet.getString(R.styleable.CardFundsWidget_name)
        attributeSet.recycle()
    }
}