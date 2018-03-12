package com.android.alekhya.revisionv3.network;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.alekhya.revisionv3.BaseApplication;
import com.android.alekhya.revisionv3.network.PojoClasses.Imagepojo;
import com.android.alekhya.revisionv3.network.PojoClasses.OptionList;
import com.android.alekhya.revisionv3.network.PojoClasses.PQustnpapers;
import com.android.alekhya.revisionv3.network.PojoClasses.QuizQuestion;
import com.android.alekhya.revisionv3.network.PojoClasses.Textbookpojo;
import com.android.alekhya.revisionv3.network.PojoClasses.User;
import com.android.alekhya.revisionv3.network.PojoClasses.Users;
import com.android.alekhya.revisionv3.network.PojoClasses.Vediopojo;
import com.android.alekhya.revisionv3.network.PojoClasses.Courses;
import com.android.alekhya.revisionv3.network.PojoClasses.Regulations;
import com.android.alekhya.revisionv3.network.PojoClasses.Sems;
import com.android.alekhya.revisionv3.network.PojoClasses.Subjects;
import com.android.alekhya.revisionv3.network.PojoClasses.Years;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public class RestApi {
    // public static String BASE_URL = "http://192.168.2.3:8080/demo/";//Connections.BASE_URL;
    public static String BASE_URL = BaseApplication.ipAddress;//Connections.BASE_URL;
    private static SharedPreferences sp;

    private static RestApi instance = null;


    public static synchronized RestApi get() {
        if (instance == null) {
            instance = new RestApi();
        }
        return instance;
    }

    public static void init(Context context) {
        sp = context.getSharedPreferences("GSS", Context.MODE_PRIVATE);
    }

    public RestService getRestService() {
        if (sp == null) {
            throw new IllegalStateException("init method should be called first.");
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        return buildAdapter(BASE_URL, RestService.class, builder);
    }

    private String getApiToken() {
        //TODO: Need to confirm on Basic or Bearer ?
        final String credentials = "Basic " + sp.getString("apiToken", "");
        //Log.e("apiToken",credentials);
        //final String base64EncodedCredentials = Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
        //return base64EncodedCredentials;
        return credentials;
    }

    private <T> T buildAdapter(String baseUrl, Class<T> clazz, OkHttpClient.Builder builder) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //
        OkHttpClient defaultHttpClient = builder
                .addInterceptor(interceptor)
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        // Request customization: add request headers
                        Request.Builder requestBuilder = original.newBuilder();
                                /*.header("Authorization", getApiToken())
                                .header("App-Id", "PROSPORT")
                                .header("Client-Type", "APP");*/
                        Request request = requestBuilder.build();
                        return chain.proceed(request);
                    }
                })
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(defaultHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(clazz);
    }

    public interface RestService {
        @FormUrlEncoded
        @POST("RegisterUser.php")
        Call<Users> registerUser(
                @Field("username") String username,
                @Field("password") String password,
                @Field("email") String email,
                @Field("firstname") String firstname,
                @Field("lastname") String lastname
         );

        @FormUrlEncoded
        @POST("loginUser.php")
        Call<Users> loginUser(
                @Field("password") String password,
                @Field("email") String email
        );

        @GET("RegulationRetrival.php")
        Call<Regulations> getRegulations();

        @GET("CourseRetrival.php")
        Call<Courses> getCourses();

        @GET("YearRetrival.php")
        Call<Years> getYears();

        @GET("SemRetrival.php")
        Call<Sems> getSemesters();

        @FormUrlEncoded
        @POST("QuestionRetrival.php")
        Call<QuizQuestion> getQuestions(@Field("sub_id") String sub);

        @FormUrlEncoded
        @POST("OptionsRetrival.php")
        Call<OptionList> getOptions(@Field("sub_id") String sub);


            @FormUrlEncoded
        @POST("SubjectRetrival.php")
        Call<Subjects> getSubjects(@Field("regulation") String regulation,
                                   @Field("course") String course,
                                   @Field("year") String year,
                                   @Field("sem") String sem

        );

        @FormUrlEncoded
        @POST("PQustnapaperRetrival.php")
        Call<PQustnpapers> getPQustnpapers(@Field("sub_id") String sub);
        @FormUrlEncoded
        @POST("UnitRetrival.php")
        Call<Textbookpojo> getTextbookpojo(@Field("sub_id") String sub);
        @FormUrlEncoded
        @POST("ImageRetrival.php")
        Call<Imagepojo> getImagepojo(@Field("sub_id") String sub);
        @FormUrlEncoded
        @POST("VedioRetrival.php")
        Call<Vediopojo> getVediopojo(@Field("sub_id") String sub);
    }
}
