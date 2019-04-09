<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html lang="zh-CN">
<head>
    <title>地区管理</title>
    <jsp:include page="/WEB-INF/common/head.jsp"></jsp:include>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <%--ztree树状图+有关产品--%>
        <div class="col-md-3">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    部门管理
                    <button type="button" class="btn btn-info" onclick="addShowArea();">
                        <span class="glyphicon glyphicon-plus">添加节点</span>
                    </button>
                    <button type="button" class="btn btn-info" onclick="showEditDialog();">
                        <span class=" glyphicon glyphicon-pencil">修改节点</span>
                    </button>
                    <button type="button" class="btn btn-info" onclick="deleteAreaInfo();">
                        <span class=" glyphicon glyphicon-trash">删除节点</span>
                    </button>
                </div>
                <div class="panel-body">
                    <ul id="areaDemo" class="ztree"></ul>
                </div>
            </div>
        </div>
        <%--标题+条件查询+表单+按钮--%>
        <div class="col-md-9">
            <%--标题内容--%>
            <div class="panel-heading" style="background-color:pink">
                <h2>飞虎电商后台管理</h2>
                <ul class="nav nav-tabs">
                    <li role="presentation">
                        <a href="#">登录人:<b>${userInfo.userName}</b>,您好！欢迎登陆！！</a>
                    </li>
                    <li role="presentation">
                        <a href="#">本次登陆次数：${userInfo.loginCount}</a>
                    </li>
                    <li>
                        <a href="#">上次登录时间:<fmt:formatDate value="${userInfo.lastLoginTime}" type="both"/></a>
                    </li>
                    <li role="presentation">
                        <a href="<%=request.getContextPath()%>/brand/listBrand.action">品牌管理</a>
                    </li>
                    <li role="presentation">
                        <a href="<%=request.getContextPath()%>/user/tolistUserInfo.action">用户管理</a>
                    </li>
                    <li role="presentation">
                        <a href="<%=request.getContextPath()%>/log/listLogInfo.action">日志管理</a>
                    </li>
                    <li role="presentation">
                        <a href="<%=request.getContextPath()%>/area/listAreaInfo.action">地区管理</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<%--要增加的弹出框--%>
<div id="addAreaInfoDialog" style="display:none;">
    <div class="panel panel-default">
        <form class="form-horizontal">
            <%--选中部门的Id--%>
            <input type="text" id="pid"/>
            <div class="form-group">
                <label for="areaName" class="col-md-4 control-label">地区描述:</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="areaName" placeholder="请选择要添加的地区名称">
                </div>
            </div>
            <div class="form-group">
                <label for="remark" class="col-md-4 control-label">地区描述:</label>
                <div class="col-md-4">
                    <textarea class="form-control" id="remark" placeholder="请对您要添加的地区进行简要描述"></textarea>
                </div>
            </div>
        </form>
    </div>
</div>
<%--要修改的弹出框--%>
<div id="editAreaInfoDialog" style="display:none;">
    <div class="panel panel-default">
        <form class="form-horizontal">
            <%--选中部门的Id--%>
            <input type="text" id="edit_id"/>
            <div class="form-group">
                <label for="edit_areaName" class="col-md-4 control-label">地区名:</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="edit_areaName" placeholder="请选择要修改的部门名">
                </div>
            </div>
            <div class="form-group">
                <label for="edit_remark" class="col-md-4 control-label">部门描述:</label>
                <div class="col-md-4">
                    <textarea class="form-control" id="edit_remark" placeholder="请对您要修改的部门进行简要描述"></textarea>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<%--将封装好的<script>文件引入--%>
<jsp:include page="/WEB-INF/common/script.jsp"></jsp:include>
<%--内容操作--%>
<script>
    $(function () {
        //初始化部门表
        innitAreaTree();
    })
    //部门表ztree展示
    function innitAreaTree() {
        //进行与ztree有关的setting配置
        var setting = {
            data: {
                simpleData: {
                    enable: true,
                    pIdKey: "pid"
                },
                key: {
                    name: "areaName"
                }
            }
        };
        //ztree展示的数据
        //发送ajax请求
        $.ajax({
            type: "post",
            url: "<%=request.getContextPath()%>/area/findAreaList.action",
            success: function (result) {
                if (result.code == 200) {
                    //渲染ztree
                    $.fn.zTree.init($("#areaDemo"), setting, result.data);
                } else {
                    bootbox.alert({
                        message: "",
                        size: "small",
                        title: "确认删除信息:"
                    });
                }

            }
        });
    }
    /**
     * 增加选中节点的子节点
     */
    function addShowArea() {
        //获取当前选中节点的集合
        var treeObj = $.fn.zTree.getZTreeObj("areaDemo");
        var nodes = treeObj.getSelectedNodes();
        if (nodes.length == 1) {
            var v_selectNode = nodes[0];
            $("#pid").attr("value", v_selectNode.id);
            var v_addAreaInfoDialog = bootbox.dialog({
                message: $("#addAreaInfoDialog").html(),
                size: "large",
                title: "确认增加信息:",
                buttons: {
                    confirm: {
                        label: '<span class="glyphicon glyphicon-ok">确认</span>',
                        className: 'btn-success',
                        callback: function () {
                            var v_areaName = $("#areaName", v_addAreaInfoDialog).val();
                            var v_pid = $("#pid", v_addAreaInfoDialog).val();
                            var v_remark = $("#remark", v_addAreaInfoDialog).val();
                            //将上述参数放入数组中
                            var v_param = {};
                            v_param.areaName = v_areaName;
                            v_param.pid = v_pid;
                            v_param.remark = v_remark;
                            $.ajax({
                                type: "post",
                                url: "<%=request.getContextPath()%>/area/addListAreaInfo.action",
                                data: v_param,
                                success: function (result) {
                                    if (result.code == 200) {
                                        //成功后，获得指定节点下的节点
                                        var treeObj = $.fn.zTree.getZTreeObj("areaDemo");
                                        var node = {};
                                        node.areaName = v_areaName;
                                        node.remark = v_remark;
                                        node.id = result.data;
                                        treeObj.addNodes(v_selectNode, node);
                                    } else {
                                        bootbox.alert({
                                            message: "",
                                            size: "small",
                                            title: "确认添加信息:"
                                        });
                                    }
                                }
                            });
                        }
                    },
                    cancel: {
                        label: '<span class="glyphicon glyphicon-remove">取消</span>',
                        className: 'btn-danger'
                    }
                },
            });
        } else {
            bootbox.alert({
                message: "请选择一个部门",
                size: "small",
                title: "确认添加信息:"
            });
        }

    }

    /**
     * 删除选中节点下的所有节点
     */
    function deleteAreaInfo() {
        //获取当前选中节点的集合
        var treeObj = $.fn.zTree.getZTreeObj("areaDemo");
        var nodes = treeObj.getSelectedNodes();
        if (nodes.length > 0) {
            bootbox.confirm({
                message: "确定要删除这条数据吗？",
                size: "small",
                title: "确认删除信息:",
                buttons: {
                    confirm: {
                        label: '<span class="glyphicon glyphicon-ok">确认</span>',
                        className: 'btn-success'
                    },
                    cancel: {
                        label: '<span class="glyphicon glyphicon-remove">取消</span>',
                        className: 'btn-danger'
                    }
                },
                callback: function (result) {
                    if (result) {
                        var nodeArr = treeObj.transformToArray(nodes);
                        //定义一个空数组
                        var idArr = [];
                        for (var i = 0; i < nodeArr.length; i++) {
                            idArr.push(nodeArr[i].id);
                        }
                        $.ajax({
                            type: "post",
                            url: "<%=request.getContextPath()%>/area/deleteAreaInfo.action",
                            data: {"ids": idArr},
                            success: function (result) {
                                if (result.code == 200) {
                                    for (var i = 0; i < nodeArr.length; i++) {
                                        treeObj.removeNode(nodeArr[i]);
                                    }
                                }
                            }
                        })
                    }
                }
            });
        } else {
            bootbox.alert({
                message: "请选择您要删除的部门",
                size: "small",
                title: "确认删除信息:"
            });
        }
    }

    /**
     * 修改选中的子节点
     */
    function showEditDialog() {
        //获取当前选中节点的集合
        var treeObj = $.fn.zTree.getZTreeObj("areaDemo");
        var nodes = treeObj.getSelectedNodes();
        if (nodes.length == 1) {
            var v_selectNode = nodes[0];
            $("#edit_id").attr("value", v_selectNode.id);
            $("#edit_areaName").attr("value", v_selectNode.areaName);
            $("#edit_remark").html(v_selectNode.remark);
            var v_editAreaInfoDialog = bootbox.dialog({
                message: $("#editAreaInfoDialog").html(),
                size: "large",
                title: "确认修改信息:",
                buttons: {
                    confirm: {
                        label: '<span class="glyphicon glyphicon-ok">确认</span>',
                        className: 'btn-success',
                        callback: function () {
                            var v_edit_areaName = $("#edit_areaName", v_editAreaInfoDialog).val();
                            var v_edit_id = $("#edit_id", v_editAreaInfoDialog).val();
                            var v_edit_remark = $("#edit_remark", v_editAreaInfoDialog).val();
                            //将上述参数放入数组中
                            var v_param = {};
                            v_param.areaName = v_edit_areaName;
                            v_param.id = v_edit_id;
                            v_param.remark = v_edit_remark;
                            $.ajax({
                                type: "post",
                                url: "<%=request.getContextPath()%>/area/updateListAreaInfo.action",
                                data: v_param,
                                success: function (result) {
                                    if (result.code == 200) {
                                        //成功后，获得指定节点下的节点
                                        var treeObj = $.fn.zTree.getZTreeObj("areaDemo");
                                        v_selectNode.areaName = v_edit_areaName;
                                        v_selectNode.remark = v_edit_remark;
                                        treeObj.updateNode(v_selectNode)
                                    } else {
                                        bootbox.alert({
                                            message: "",
                                            size: "small",
                                            title: "确认修改信息:"
                                        });
                                    }
                                }
                            });
                        }
                    },
                    cancel: {
                        label: '<span class="glyphicon glyphicon-remove">取消</span>',
                        className: 'btn-danger'
                    }
                },
            });
        } else {
            bootbox.alert({
                message: "请选择一个部门",
                size: "small",
                title: "确认修改信息:"
            });
        }
    }

</script>
</html>
