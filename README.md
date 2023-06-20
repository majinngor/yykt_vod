# yykt_vod
#### 工程目录结构



**模块说明**

**yykt_parent：**依云课堂根目录（父工程），管理多个子模块：

**common：公共模块父节点**

​    common_util：工具类模块，所有模块都可以依赖于它

​    service_utils：service服务的base包，包含service服务的公共配置类，所有service模块依赖于它

​    rabbit_utils：rabbitmq封装工具类

**model：实体类相关模块**

**server-gateway：服务网关**

**service：api接口服务父节点**

​	service_acl：权限管理接口服务

​	service_activity：优惠券api接口服务

​	service_live：直播课程api接口服务

​	service_order：订单api接口服务

​	service_user：用户api接口服务

​	service_vod：点播课程 api接口服务

​	service_wechat：公众号api接口服务

**service-client：feign服务调用父节点**

​	service-activity-client：优惠券api接口

​	service-live-client：直播课程api接口

​	service-order-client：订单api接口

​	service-user-client：用户api接口

​	service-vod-client：点播课程api接口
