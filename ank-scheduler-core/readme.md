##说明文档
1. ank-scheduler属于spring web项目，只支持spring web项目，要求jdk版本1.8+;
2. 默认调度中心地址需要在执行器中配置，请在执行器端配置文件中配置ank.scheduler.address，
例如ank.scheduler.address: xxx;如果不配置或配置为空，则不启用执行器组件；
3. 开发一个Task任务只需要加注解@AnkTask，实现IAnkTask接口,配置添加扫描包"ank.hao.core";
4. 不同的应用应用名不能相同spring.application.name；


##TODO
1. 调度中心调度执行任务；
2. 页面接口定义；
3. 任务调度设计；

4. 任务停止；真的需要停止任务吗？
   如果任务可重复执行，则不需要停止；依赖应用本身的管理，例如超时来控制；
   如果任务不可重复执行，则不需要额外参数，执行参数即可确定唯一在运行任务；
5. 作业和任务参数：超时、失败策略、依赖和顺序；

6. 任务编排后，部分任务并发执行优化;

##前端工作
1. 原有接口改动：接口名称修改，少量接口参数格式修改；需要加一些额外参数；
2. 新增任务管理和执行器管理两个模块；（简单的查询列表）

##执行器对接方工作
1. 实现执行和关闭接口，根据传递的参数（执行和关闭接收相同参数）；调度中心不会记录执行器端的额外业务参数信息；
2. 关于获取参数列表————a. 放到IAnkTask接口中实现，但如果层级关系过多或数据过多，网络压力大；
                    b. 交由执行器对接方和前端交互，业务参数与调度平台完全无关；

##后续计划
1. 动态可插拔；
2. 作业中单个任务失败处理策略；

##页面部分修改点：
1. 作业状态只有启用和停用，和任务具体状态无关；
{
  "queryType": 1,
  "params": 
  {
  "projectId": "223344"
	}
}