# MyAdapter
适配器
[![](https://jitpack.io/v/ForMuHan/MyAdapter.svg)](https://jitpack.io/#ForMuHan/MyAdapter)

 Step 1.Add it in your root build.gradle at the end of repositories:

	```java
  allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  
  Step 2. Add the dependency
  

	```java
  dependencies {
	        implementation 'com.github.ForMuHan:MyAdapter:Tag'
	}
  ```

- 需要引入DataBinding
- 用户需要自己写布局，在布局文件中设置填充数据源
