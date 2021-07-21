package com.example.fixer.ui.main

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fixer.R
import com.example.fixer.domain.Currency
import com.example.fixer.ui.extensions.basicDiffUtil
import com.example.fixer.ui.extensions.inflate
import com.example.fixer.ui.extensions.round

class CurrencyAdapter : RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {

    private lateinit var mholder: ViewHolder
    private lateinit var currency: Currency

    var currencies: MutableList<Currency> by basicDiffUtil(
        mutableListOf(),
        areItemsTheSame = { old, new -> old.timestamp == new.timestamp }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_fixer_currency, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = currencies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        mholder = holder
        currency = currencies[position]
        holder.bind(currency)
    }

    fun setAmount(currency: Currency, amount: Double) {
        mholder.setAmounts(currency, amount)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var currencyUsdTitle: TextView
        private var currencyJpyTitle: TextView
        private var currencyGbpTitle: TextView
        private var currencyBrlTitle: TextView

        init {
            super.itemView
            currencyUsdTitle = itemView.findViewById(R.id.titleUsdTextView)
            currencyJpyTitle = itemView.findViewById(R.id.titleJpyTextView)
            currencyGbpTitle = itemView.findViewById(R.id.titleGbpTextView)
            currencyBrlTitle = itemView.findViewById(R.id.titleAustraliaTextView)
        }

        @SuppressLint("SetTextI18n")
        fun bind(currency: Currency) {
            currencyUsdTitle.text = currency.rates?.usd?.round(2).toString()
            currencyJpyTitle.text = currency.rates?.jpy?.round(2).toString()
            currencyGbpTitle.text = currency.rates?.gbp?.round(2).toString()
            currencyBrlTitle.text = currency.rates?.aud?.round(2).toString()
        }

        @SuppressLint("SetTextI18n")
        fun setAmounts(currency: Currency, amount: Double) {
            if (amount == 0.0) {
                bind(currency)
                return
            }
            currencyUsdTitle.text = "${(amount * currency.rates?.usd!!).round(2)}"
            currencyJpyTitle.text = "${(amount * currency.rates?.jpy!!).round(2)}"
            currencyGbpTitle.text = "${(amount * currency.rates?.gbp!!).round(2)}"
            currencyBrlTitle.text = "${(amount * currency.rates?.aud!!).round(2)}"
        }
    }
}