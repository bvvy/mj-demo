package com.ying.core.data.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author bvvy
 * @date 2018/7/17
 */
@ConfigurationProperties(prefix = "aliyun")
@Component
@Data
public class AliOssProperties {
    private String endPoint;

    private String accessKeyId;

    private String secretAccessKey;

    private String bucketName;

    private String fileHost;

}
