package com.zc.common.result;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 全局统一结果返回
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 是否成功
     */
    private Boolean status;

    /**
     * 服务器当前时间戳
     */
    private Long time = System.currentTimeMillis();

    /**
     * 成功数据
     */
    private T data;

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误描述
     */
    private String msg;

    public static Result ofSuccess() {
        Result result = new Result();
        result.status = true;
        return result;
    }

    public static Result ofSuccess(Object data) {
        Result result = new Result();
        result.status = true;
        result.setData(data);
        result.setCode(0);
        result.setMsg("操作成功！");
        return result;
    }

    public static Result ofFail(int code, String msg) {
        Result result = new Result();
        result.status = false;
        result.code = code;
        result.msg = msg;
        return result;
    }

    public static Result ofFail(int code, String msg, Object data) {
        Result result = new Result();
        result.status = false;
        result.code = code;
        result.msg = msg;
        result.setData(data);
        return result;
    }

    /**
     * 获取 json
     */
    public String buildResultJson(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", this.status);
        jsonObject.put("code", this.code);
        jsonObject.put("time", this.time);
        jsonObject.put("msg", this.msg);
        jsonObject.put("data", this.data);
        return JSON.toJSONString(jsonObject, SerializerFeature.DisableCircularReferenceDetect);
    }

}
