package alpha.qdev.sunshine;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static int FINE_LOCATION_REQUEST = 0x0;
    private static int COARSE_LOCATION_REQUEST = 0x1;
    private static int NETWORK_LOCATION_REQUEST = 0x2;
    private static int VIBRATION_REQUEST = 0x3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Configuration config;

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
            //the device uses runtime permissions, check them at each app start
            config = this.updatePermissionsApi23();
        }
        else {
            //the permissions have been granted when installed, no need to worry about them
            config = this.updatePermissionsLessThan23();
        }

        config = this.loadSettings(config); //set the runtime flags
        
        this.loadUi(config);               //load and update the UI according to the flags in config

    }

    /**
     *Called on systems with API<23
     * @return a config object with the permissions set to allowed
     */
    private Configuration updatePermissionsLessThan23() {
        Configuration config = new Configuration();

        config.fineLocationAllowed = true;
        config.coarseLocationAllowed = true;
        config.networkAllowed = true;
        config.vibrationAllowed = true;

        return config;
    }

    /**
     * Called on systems with API>=23
     * @return a config object with the permission flags set, the others untouched
     */
    private Configuration updatePermissionsApi23() {
        Configuration config = new Configuration();

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {

            }
            else {
                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, FINE_LOCATION_REQUEST);
            }
        }
        else {
            //isFineLocationAllowed = true;
        }

        return config;

    }


    /**
     * Load all the views and populate the text field according to the already stored data
     */
    private void loadUi(Configuration config) {

    }

    /**
     * Read the settings from the storage and set the flags accordingly
     * @param config: object to be updated
     * @return a Configuration object representing the flag configuration in the current run
     */
    private Configuration loadSettings(Configuration config) {

        return config;
    }

    /**
     *
     * @param config: the configuration flags to be written into the settings file
     * @return true if the writing process succeeded, false otherwise
     */
    private boolean storeSettings(Configuration config) {
        return true;
    }
}
