package com.wj.plugin;
import com.android.build.gradle.AppPlugin;
import org.gradle.api.Action;
import org.gradle.api.GradleException;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;
public class MyPlugin implements Plugin<Project> {
	@Override public void apply(Project project) {
		if (!project.getPlugins().hasPlugin(AppPlugin.class)) {
			throw new GradleException("无法在非android application插件中使用gradle插件");
		}
		//task测试，可以通过命令执行：gradlew testTask,测试改task执行情况
		project.task("testTask").doFirst(new Action<Task>() {
			@Override public void execute(Task task) {
				System.out.println("task Test....");
			}
		});
		//"user"使用插件是，相应的配置
		project.getExtensions().create("user",Person.class);

		project.afterEvaluate(new Action<Project>() {
			@Override public void execute(Project project) {
				//获取使用过程中的相应配置参数
				Person user= (Person) project.getExtensions().findByName("user");
				if (user!=null){
					System.out.println("findByName--->"+user.toString());
				}else {
					System.out.println("findByName--->NULL");
				}
				Person person=project.getExtensions().findByType(Person.class);
				if (person!=null){
					System.out.println("findByType--->"+person.toString());
				}else {
					System.out.println("findByType--->NULL");
				}
			}
		});
	}
}
