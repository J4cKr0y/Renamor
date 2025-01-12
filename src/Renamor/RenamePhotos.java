package Renamor;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RenamePhotos {
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\Terrier\\Desktop\\Tardis\\Camera\\rename");
        File[] files = dir.listFiles((d, name) -> name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".jpeg")); 

        if (files != null) {
            for (File file : files) {
                try {
                    Metadata metadata = ImageMetadataReader.readMetadata(file);
                    ExifSubIFDDirectory directory = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
                    String newFileName;

                    if (directory != null) {
                        Date date = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                        newFileName = sdf.format(date) + ".jpg";
                    } else {
                        long lastModified = file.lastModified();
                        Date date = new Date(lastModified);
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                        newFileName = sdf.format(date) + ".jpg";
                    }

                    File newFile = new File(dir, newFileName);
                    if (!file.renameTo(newFile)) {
                        System.out.println("Could not rename " + file.getName());
                    } else {
                        System.out.println("Renamed to " + newFileName);
                    }
                } catch (Exception e) {
                    System.err.println("Error processing " + file.getName() + ": " + e.getMessage());
                }
            }
        }
    }
}
