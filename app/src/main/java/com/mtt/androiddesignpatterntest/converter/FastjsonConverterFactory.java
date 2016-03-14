package com.mtt.androiddesignpatterntest.converter;

import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import retrofit.Converter;

/**
 * Description: fastjson converter
 * Created by Kerry on 16/3/14.
 */
public class FastjsonConverterFactory extends Converter.Factory{

    public static FastjsonConverterFactory create() {
        return new FastjsonConverterFactory();
    }

    public FastjsonConverterFactory() {
    }

    @Override
    public Converter<ResponseBody, ?> fromResponseBody(Type type, Annotation[] annotations) {
        return new FastjsonResponseBodyConverter<>(type);
    }

    @Override
    public Converter<?, RequestBody> toRequestBody(Type type, Annotation[] annotations) {
        return new FastjsonRequestBodyConverter<>();
    }
}
