package github.polarisink.basic.params;

import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.FileUpload;
import io.vertx.up.annotations.EndPoint;
import io.vertx.up.util.Ut;

import javax.ws.rs.BodyParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.StreamParam;
import java.util.UUID;

/**
 * @author hzsk
 */
@EndPoint
public class BodyDataAgent {

  @POST
  @Path("/hi/param/body-string")
  public JsonObject sayBody(@BodyParam final JsonObject data) {
    return data;
  }

  /**
   * StreamParam用于二进制流的请求
   *
   * @param fileUpload
   * @return
   */
  @POST
  @Path("/hi/param/body-file")
  public JsonObject sayFile(@StreamParam final FileUpload fileUpload) {
    final JsonObject uploaded = new JsonObject();
    // 上传文件
    final String originalFile = fileUpload.fileName();
    // 计算文件名和文件扩展名的简易代码
    final int lastIndex = originalFile.lastIndexOf('.');
    final String fileName = originalFile.substring(0, lastIndex);
    final String extension = originalFile.substring(lastIndex + 1);
    uploaded.put("key", UUID.randomUUID().toString());
    uploaded.put("status", "PROGRESS");
    uploaded.put("name", originalFile);
    uploaded.put("fileKey", Ut.randomString(64));
    uploaded.put("fileName", fileName);
    uploaded.put("filePath", fileUpload.uploadedFileName());
    uploaded.put("extension", extension);
    uploaded.put("module", "x_module");
    uploaded.put("mime", fileUpload.contentType());
    uploaded.put("size", fileUpload.size());
    uploaded.put("language", "cn");
    uploaded.put("metadata", new JsonObject().encode());
         /*
         附件主键
         .put("storeWay", config.getFileStorage())       // 文件存储方式
         上传进度
         上传文件名
         文件随机码
         原始文件名
         文件路径
         扩展名
         模块名称
         文件的MIME
         文件尺寸
         多语言环境
         配置信息，保留
         Zero Extension 中的 Ambient 模块专用（正式生产环境只需要下边一行即可）
         return At.upload("stream.file", file);*/
    return uploaded;
  }
}