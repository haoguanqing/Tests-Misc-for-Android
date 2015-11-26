package com.guanqing.zzzz;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import net.dean.jraw.RedditClient;
import net.dean.jraw.http.NetworkException;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.http.oauth.Credentials;
import net.dean.jraw.http.oauth.OAuthData;
import net.dean.jraw.http.oauth.OAuthException;
import net.dean.jraw.http.oauth.OAuthHelper;

import java.net.URL;

/**
 * Created by Guanqing on 2015/11/12.
 */
public class JrawActivity extends AppCompatActivity{
    UserAgent mUserAgent;
    static RedditClient redditClient;

    WebView webView;
    int loadCount = 0;
    String username = "besttth9";
    String password = "besttth3";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jraw);

        mUserAgent = UserAgent.of("Android", "com.guanqing.zzzz", "1.0", "besttth9");
        redditClient = new RedditClient(mUserAgent);
        final OAuthHelper helper = redditClient.getOAuthHelper();
        final net.dean.jraw.http.oauth.Credentials credentials =
                net.dean.jraw.http.oauth.Credentials.installedApp("p6NSlEAAL8HerQ", "http://haoguanqing.github.io/Tests-Misc-for-Android/");
        boolean permanent = true;
        String[] scopes = {"identity", "read"};

        URL authorizationUrl = helper.getAuthorizationUrl(credentials,permanent, scopes);

/*        webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl(authorizationUrl.toExternalForm());
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                if(url.contains("code=")){
                    new UserChallengeTask(helper,credentials).execute(url);
                }
            }
        });*/

        webView = (WebView) findViewById(R.id.webView);
        //webView.setVisibility((View.GONE));
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new jsInterface(), "HTMLOUT");

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                if (loadCount == 0) {
                    String getButtonJS = "javascript:var els = document.getElementsByClassName('c-btn c-btn-primary c-pull-right');" +
                            "javascript:els[1].click();";
                    webView.loadUrl(
                            "javascript:document.getElementById('user_login').value = '" + username + "';" +
                                    "javascript:document.getElementById('passwd_login').value = '" + password + "';" +
                                    getButtonJS
                    );
                    loadCount++;
                } else if (loadCount == 1) {
                    webView.loadUrl("javascript:document.getElementsByClassName('fancybutton newbutton allow')[0].click();");
                    loadCount++;
                }

                //log out
                else if (loadCount == 2) {
                    webView.loadUrl("https://www.reddit.com/");
                    loadCount++;
                } else {
                    webView.loadUrl("javascript:document.forms[0].submit();");
                    onBackPressed();
                }
            }
        });
        webView.loadUrl(authorizationUrl.toExternalForm());


        //off the screen
//        WebView webView = new WebView(getApplicationContext());
//        webView.loadUrl("your-url");
    }

    private static final class UserChallengeTask extends AsyncTask<String, Void, OAuthData>{
        private OAuthHelper helper;
        private Credentials creds;

        public UserChallengeTask(OAuthHelper helper, Credentials creds){
            this.helper = helper;
            this.creds = creds;
        }

        @Override
        protected OAuthData doInBackground(String... params) {
            try{
               return helper.onUserChallenge(params[0],creds);
            }catch (NetworkException | OAuthException e){
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(OAuthData oAuthData) {
            if(oAuthData!=null){
                redditClient.authenticate(oAuthData);
            }
        }
    }

    class jsInterface{
        public void showHTML(String html){
            String test = "";
            Intent openNewActivity = new Intent("android.intent.action.showHTMLintent");
            startActivity(openNewActivity);
        }
    }
}
