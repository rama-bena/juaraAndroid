// Generated by view binder compiler. Do not edit!
package com.example.dogglers.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.example.dogglers.R;
import com.google.android.material.card.MaterialCardView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class GridListItemBinding implements ViewBinding {
  @NonNull
  private final MaterialCardView rootView;

  @NonNull
  public final TextView dogAgeGridText;

  @NonNull
  public final ImageView dogGridImage;

  @NonNull
  public final TextView dogHobbiesGridText;

  @NonNull
  public final TextView dogNameGridText;

  private GridListItemBinding(@NonNull MaterialCardView rootView, @NonNull TextView dogAgeGridText,
      @NonNull ImageView dogGridImage, @NonNull TextView dogHobbiesGridText,
      @NonNull TextView dogNameGridText) {
    this.rootView = rootView;
    this.dogAgeGridText = dogAgeGridText;
    this.dogGridImage = dogGridImage;
    this.dogHobbiesGridText = dogHobbiesGridText;
    this.dogNameGridText = dogNameGridText;
  }

  @Override
  @NonNull
  public MaterialCardView getRoot() {
    return rootView;
  }

  @NonNull
  public static GridListItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static GridListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.grid_list_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static GridListItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.dog_age_grid_text;
      TextView dogAgeGridText = rootView.findViewById(id);
      if (dogAgeGridText == null) {
        break missingId;
      }

      id = R.id.dog_grid_image;
      ImageView dogGridImage = rootView.findViewById(id);
      if (dogGridImage == null) {
        break missingId;
      }

      id = R.id.dog_hobbies_grid_text;
      TextView dogHobbiesGridText = rootView.findViewById(id);
      if (dogHobbiesGridText == null) {
        break missingId;
      }

      id = R.id.dog_name_grid_text;
      TextView dogNameGridText = rootView.findViewById(id);
      if (dogNameGridText == null) {
        break missingId;
      }

      return new GridListItemBinding((MaterialCardView) rootView, dogAgeGridText, dogGridImage,
          dogHobbiesGridText, dogNameGridText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
