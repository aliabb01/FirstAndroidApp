package ali.app.firstandroidapp;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class ListItem implements Parcelable {
    private String title;
    private Bitmap image;
    private String description;

    public ListItem() {

    }

    public ListItem(String title, Bitmap image, String description) {
        this.title = title;
        this.image = image;
        this.description = description;
    }

    protected ListItem(Parcel in) {
        title = in.readString();
        image = (Bitmap) in.readValue(Bitmap.class.getClassLoader());
        description = in.readString();
    }

    public static final Creator<ListItem> CREATOR = new Creator<ListItem>() {
        @Override
        public ListItem createFromParcel(Parcel in) {
            return new ListItem(in);
        }

        @Override
        public ListItem[] newArray(int size) {
            return new ListItem[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title=title;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeValue(image);
        parcel.writeString(description);
    }
}
