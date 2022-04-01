/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.data.DataSource
import com.example.dogglers.model.Dog

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
) : RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {


    val dataset: List<Dog> = DataSource.dogs

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        val dogVerhonImage: ImageView? = view?.findViewById(R.id.dog_verhon_image)
        val nameVerhonText: TextView? = view?.findViewById(R.id.dog_name_verhon_text)
        val ageVerhonText: TextView? = view?.findViewById(R.id.dog_age_verhon_text)
        val hobbiesVerhonText: TextView? = view?.findViewById(R.id.dog_hobbies_verhon_text)

        val dogGridImage: ImageView? = view?.findViewById(R.id.dog_grid_image)
        val nameGridText: TextView? = view?.findViewById(R.id.dog_name_grid_text)
        val ageGridText: TextView? = view?.findViewById(R.id.dog_age_grid_text)
        val hobbiesGridText: TextView? = view?.findViewById(R.id.dog_hobbies_grid_text)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        val adapterLayout = when (layout) {
            1, 2 -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.vertical_horizontal_list_item, parent, false)
            }
            else -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.grid_list_item, parent, false)
            }
        }
        return DogCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val item = dataset[position]
        val resources = context?.resources

        when(layout) {
            1,2 -> {
                holder.dogVerhonImage?.setImageResource(item.imageResourceId)
                holder.nameVerhonText?.text = item.name
                holder.ageVerhonText?.text = resources?.getString(R.string.dog_age, item.age)
                holder.hobbiesVerhonText?.text = resources?.getString(R.string.dog_hobbies, item.hobbies)
            }
            3 -> {
                holder.dogGridImage?.setImageResource(item.imageResourceId)
                holder.nameGridText?.text = item.name
                holder.ageGridText?.text = resources?.getString(R.string.dog_age, item.age)
                holder.hobbiesGridText?.text = resources?.getString(R.string.dog_hobbies, item.hobbies)
            }
        }
    }
}
