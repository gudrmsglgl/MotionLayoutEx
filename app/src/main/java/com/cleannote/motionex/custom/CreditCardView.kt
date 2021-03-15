package com.cleannote.motionex.custom

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import com.cleannote.motionex.R
import com.google.android.material.card.MaterialCardView

class CreditCardView: MaterialCardView {

    private lateinit var cardView: MaterialCardView
    private lateinit var cardTitle: TextView

    constructor(context: Context?) : super(context) {
        initView()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initView()
        getAttrs(attrs)
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView()
        getAttrs(attrs, defStyleAttr)
    }

    private fun initView(){
        val infService = Context.LAYOUT_INFLATER_SERVICE
        val li: LayoutInflater = context.getSystemService(infService) as LayoutInflater
        val view = li.inflate(R.layout.custom_layout_card, this, false)
        addView(view)

        cardView = findViewById(R.id.custom_card_container)
        cardTitle = findViewById(R.id.custom_card_title)
    }

    private fun getAttrs(attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CreditCardView)
        setTypeArray(typedArray)
    }

    private fun getAttrs(attrs: AttributeSet?, defStyleAttr: Int) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CreditCardView,  defStyleAttr, 0)
        setTypeArray(typedArray)
    }

    private fun setTypeArray(typedArray: TypedArray){
        val bg = typedArray.getColor(R.styleable.CreditCardView_cardBg,0)
        cardView.setCardBackgroundColor(bg)

        val titleText = typedArray.getString(R.styleable.CreditCardView_cardTitle)
        cardTitle.text = titleText

        val titleColor = typedArray.getColor(R.styleable.CreditCardView_cardTitleColor, 0)
        cardTitle.setTextColor(titleColor)
    }
}