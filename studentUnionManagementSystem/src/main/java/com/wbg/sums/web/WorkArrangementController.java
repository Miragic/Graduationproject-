package com.wbg.sums.web;

import com.github.pagehelper.PageHelper;
import com.wbg.sums.util.Result;
import com.wbg.sums.entity.WorkArrangement;
import com.wbg.sums.service.WorkArrangementService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workArrangement")
public class WorkArrangementController {
    @Autowired
    private WorkArrangementService workArrangementService;

    /**
     * 根据pId删除
     *
     * @param workArrangement
     * @return
     */
    @GetMapping("/deleteByPrimaryKey")
    @RequiresRoles("admin")
    public Result deleteByPrimaryKey(WorkArrangement workArrangement) {
        try {
            return workArrangementService.deleteByPrimaryKey(workArrangement.getwId()) > 0 ? new Result().successMessage("删除成功") : new Result("删除失败");
        } catch (Exception ex) {
            return new Result().error("删除失败！请确定是否有依赖，再重试！");
        }
    }

    /**
     * 添加对象WorkArrangement
     *
     * @param workArrangement
     * @return
     */
    @PostMapping("/insert")
    @RequiresPermissions({"insert"})
    public Result insert(@RequestBody WorkArrangement workArrangement) {
        try {
            return workArrangementService.insert(workArrangement) > 0 ? new Result().successMessage("添加成功！") : new Result("添加失败！");
        } catch (Exception ex) {
            return new Result().error("出错,请重试！");
        }

    }

    /**
     * 根据pId查找对象  最多只能返回一个对象
     *
     * @param workArrangement
     * @return
     */
    @GetMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(WorkArrangement workArrangement) {
        try {
            WorkArrangement workArrangement1 = workArrangementService.selectByPrimaryKey(workArrangement.getwId());
            if (workArrangement1 == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(workArrangement1);
            }
        } catch (Exception ex) {
            return new Result().error("出错,请重试！");
        }
    }

    /**
     * 查询所有数据
     *
     * @return
     */
    @GetMapping("/selectAll")
    public Result selectAll(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<WorkArrangement> list = workArrangementService.selectAll();
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(list, workArrangementService.counts(0, null));
            }
        } catch (Exception ex) {
            return new Result().error("出错,请重试！");
        }
    }

    /**
     * 根据a_id修改全部字段
     *
     * @param workArrangement
     * @return
     */
    @PostMapping("/updateByPrimaryKey")
    @RequiresPermissions({"update"})
    public Result updateByPrimaryKey(@RequestBody WorkArrangement workArrangement) {
        try {
            return workArrangementService.updateByPrimaryKey(workArrangement) > 0 ? new Result().successMessage("修改成功") : new Result("修改失败");
        } catch (Exception ex) {
            return new Result().error("出错,请重试！");
        }
    }

    /**
     * 获取不重复的标题
     *
     * @return
     */
    @GetMapping("/selectGroupBy")
    public Result selectGroupBy() {
        try {
            List<WorkArrangement> list = workArrangementService.selectGroupBy();
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(list, workArrangementService.counts(0, null));
            }
        } catch (Exception ex) {
            return new Result().error("出错,请重试！");
        }
    }

    /**
     * 根据负责人查询工作
     */
    @GetMapping("/selectmName")
    public Result selectmName(String mName) {
        try {
            List<WorkArrangement> list = workArrangementService.selectmName(mName);
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(list, workArrangementService.counts(0, mName));
            }
        } catch (Exception ex) {
            return new Result().error("出错,请重试！");
        }
    }

    /**
     * 根据部门查询工作
     */
    @GetMapping("/selectAllVagueName")
    public Result selectAllVagueName(int dId) {
        try {
            List<WorkArrangement> list = workArrangementService.selectAllVagueName(dId);
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(list, workArrangementService.counts(dId, null));
            }
        } catch (Exception ex) {
            return new Result().error("出错,请重试！");
        }
    }

    /**
     * 根据时间查询
     */
    @GetMapping("/selectDate")
    public Result selectDate(String beforeDate, String afterDate, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<WorkArrangement> list = workArrangementService.selectDate(beforeDate, afterDate);
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(list, workArrangementService.count(beforeDate, afterDate));
            }
        } catch (Exception ex) {
            return new Result().error("出错,请重试！");
        }
    }
}
