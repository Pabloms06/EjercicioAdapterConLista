package com.example.ejercicioadapterconlista


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.CheckBox
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class StringAdapter (var ordenadores : MutableList<String>) : RecyclerView.Adapter<StringAdapter.StringViewHolder>() {

    class StringViewHolder(var root: View, var textView: TextView, var checkBox: CheckBox) : RecyclerView.ViewHolder(root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val twTextView = view.findViewById<TextView>(R.id.recyclerView)
        val checkBox = view.findViewById<CheckBox>(R.id.checkBox6)
        return StringViewHolder(view, twTextView,checkBox)
    }

    override fun getItemCount(): Int {
        return ordenadores.size + 1
    }

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        if (position == itemCount - 1) {
            holder.textView.text = "Borrar"
            holder.root.setOnClickListener {
                val toast = Toast.makeText(it.context, "Eliminando", Toast.LENGTH_LONG)
                toast.show()
                ordenadores.remove(String())
                notifyDataSetChanged()
            }
            return
        }

        if (position == itemCount - 1) {
            holder.textView.text = "Insertar"
            holder.root.setOnClickListener {
                val toast = Toast.makeText(it.context, "Insertando...", Toast.LENGTH_LONG)
                toast.show()
                ordenadores.add("Ordenador$position")
                notifyDataSetChanged()
            }
            return
        }

        if (position > 0) {
            holder.textView.text = ordenadores[position]
            holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.teal_200))
        }

       for (i in position.rangeTo(position)) {

            if (holder.checkBox.isChecked) {

                var contador = i.inc()

                holder.textView.text = "Contar encendidos"
                holder.root.setOnClickListener {
                    val toast = Toast.makeText(it.context, "Calculando...", Toast.LENGTH_LONG)
                    toast.show()
                    notifyDataSetChanged()
                    val toast2 = Toast.makeText(it.context, "Hay $contador encendidos", Toast.LENGTH_LONG)
                    toast2.show()
                    notifyDataSetChanged()


                }
            }


        }


    }

}
