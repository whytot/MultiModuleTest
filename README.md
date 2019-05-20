# MultiModuleTest
Dagger2实现组件化通信<br/>

1 lib实现base层的抽象服务后，将具体实现放在各自的Module中；<br/>
2 app层的Component中集成各个lib中的Module；<br/>
3 base层提供抽象服务和服务集合，上层组建通过服务集合访问其他lib；<br/>
  3.1 base层的服务集合中持有的所有服务对象使用懒加载（Lazy）。<br/>
