
package com.thanhpcc;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import java.io.File;
import com.facebook.react.views.text.ReactFontManager;

public class RNFontLoaderModule extends ReactContextBaseJavaModule {
  private final ReactApplicationContext reactContext;
  private static final String ASSET_SCHEME = "asset://";

  public RNFontLoaderModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @ReactMethod
  public void loadFontAsync(final String fontFamilyName, final String localUri, final Promise promise) {
       try{
         Typeface typeFace;
         //load font from asset folder
         if(localUri.startsWith(ASSET_SCHEME)){
           typeface = Typeface.createFromAsset(
            getContext().getAssets(),
            // Also remove the leading slash.
            localUri.substring(ASSET_SCHEME.length() + 1));
         } else {
           File file =  new File(Uri.parse(localUri).getPath());
           if(f.exists() && f.canRead()){
            typeface = Typeface.createFromFile(file);
           } else {
             promise.reject('FILE_NOT_FOUND_OR_HAVE_NOT_PERMISSION_TO_LOAD_FILE')
             return;
           }
         }
         ReactFontManager.getInstance().setTypeface(fontFamilyName, typeFace.getStyle(), typeFace);
         promise.resolve(true)
       } catch(Exception e){
         promise.reject(e.getMessage())
       }
    }

  @ReactMethod
  public void downLoadFontFromURL(final String fontName, final String Url, final Promise promise){

  }
   public String updateBundle(String url, boolean update) throws IOException{
        String filepath = getModulesPath();
        String downloadModulesFilePath = filepath;

        InputStream inputStream = null;
        try {
            URL bundleUrl = new URL(url);
            // Using BufferedInputStream for fastest performance
            inputStream =  new BufferedInputStream(bundleUrl.openConnection().getInputStream());
            File moduleFile = new File(filepath);
            if(!update && moduleFile.exists()) {
                // write downloaded module to temp file (should be temporary file)
                downloadModulesFilePath = getDownloadModulesPath();
                FileUtils.writeStreamToFile(inputStream, new File(downloadModulesFilePath), false);
                // update content of modules for later load
                FileUtils.writeStreamToFile(inputStream, moduleFile, true);
            } else {
                FileUtils.writeStreamToFile(inputStream, moduleFile, false);
            }
        } catch (MalformedURLException e) {
            ReactRestartUtils.log(e);
            throw new ReactRestartUnknownException(url, e);
        } finally {
            if (inputStream != null) inputStream.close();
        }

        return downloadModulesFilePath;
    }

  @Override
  public String getName() {
    return "RNFontLoader";
  }
}