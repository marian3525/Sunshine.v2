package alpha.qdev.sunshine;

/**
 * Created by Marian on 12/15/2017.
 */

public class Configuration {
    /*
    Class to store the flags which determine the way the app works
     */

    //runtime flags
    protected boolean soundAllowed;
    protected String unitType;    //imperial or metric
    protected int updateInterval;
    protected boolean freshStart;
    protected int themeType;
    protected String apiURL;
    protected String apiResponseType; //xml or json

    //permission flags
    protected boolean fineLocationAllowed;
    protected boolean coarseLocationAllowed;
    protected boolean networkAllowed;
    protected boolean vibrationAllowed;
}
