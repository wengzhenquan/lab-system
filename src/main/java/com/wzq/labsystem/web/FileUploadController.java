package com.wzq.labsystem.web;

import com.wzq.labsystem.dto.ResultDto;
import com.wzq.labsystem.utils.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Api(tags ={"5 文件上传"})
public class FileUploadController {

    @Autowired
    FileUtil fileUtil;

    @ApiOperation("单文件上传")
    @PostMapping("fileUpload")
    public ResultDto<String> fileUpload(@RequestParam MultipartFile file) {
        return ResultDto.ok(fileUtil.fileUpload(file));
    }

    @ApiOperation("批量上传")
    @PostMapping("bacthFileUpload")
    public ResultDto<List<String>> bacthFileUpload(@RequestParam MultipartFile[] files) {
        return ResultDto.ok(fileUtil.bacthFileUpload(files));
    }

    @ApiOperation("删除文件")
    @PostMapping("delFile")
    public ResultDto<String> delFile(@RequestParam String path) {
        return ResultDto.ok(fileUtil.delFile(path));
    }
}
