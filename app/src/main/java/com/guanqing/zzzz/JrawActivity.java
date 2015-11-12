package com.guanqing.zzzz;

import android.graphics.Bitmap;
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
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl(authorizationUrl.toExternalForm());
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                if(url.contains("code=")){
                    new UserChallengeTask(helper,credentials).execute(url);
                }
            }
        });

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
}
