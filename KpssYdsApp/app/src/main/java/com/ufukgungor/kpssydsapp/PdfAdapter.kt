package com.ufukgungor.kpssydsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ufukgungor.kpssydsapp.databinding.KpssrecylerviewitemBinding

class PdfAdapter(val pdfList: ArrayList<Pdf>): RecyclerView.Adapter<PdfAdapter.PdfHolder>() {

        class PdfHolder(val binding: KpssrecylerviewitemBinding): RecyclerView.ViewHolder(binding.root){

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PdfHolder {
        val binding= KpssrecylerviewitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PdfHolder(binding)
    }

    override fun onBindViewHolder(holder: PdfHolder, position: Int) {
        holder.binding.pdfRecylerViewTextView.text=pdfList.get(position).pdfName

    }

    override fun getItemCount(): Int {
        return pdfList.size
    }
}