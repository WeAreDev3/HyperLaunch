package com.dev3.hyperlaunch.hyperlaunch;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class WebInterface {
    Context context;

    WebInterface (Context newContext) {
        context = newContext;
    }

    @JavascriptInterface
    public void toast (String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public String apps () {
        PackageManager manager = context.getPackageManager();
        List<ApplicationInfo> list = manager.getInstalledApplications(0);
        String apps = "[";

        for (ApplicationInfo app : list) {
            String appName = app.packageName;
            if (manager.getLaunchIntentForPackage(appName) != null) {
                String name = (String) manager.getApplicationLabel(app);
                Uri iconURI = Uri.parse("android.resource://" + appName + "/" + app.icon);
                apps += "{\"launchName\":\"" + name + "\",\"packageName\":\"" + appName + "\",\"iconUri\":\"" + iconURI + "\"},";
            }
        }

        apps = apps.substring(0, apps.length() - 1) + "]";

        return apps;
    }

    @JavascriptInterface
    public void launch (String packageName) {
        Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        context.startActivity(launchIntent);
    }
}
