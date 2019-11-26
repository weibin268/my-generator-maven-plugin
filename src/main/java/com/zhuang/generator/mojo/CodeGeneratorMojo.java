package com.zhuang.generator.mojo;

import com.zhuang.generator.CodeGenerator;
import com.zhuang.generator.config.MyGeneratorProperties;
import com.zhuang.generator.util.PathUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.FileInputStream;

@Mojo(name = "generate", defaultPhase = LifecyclePhase.COMPILE, requiresProject = true)
public class CodeGeneratorMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project.build.outputDirectory}")
    private File outputDirectory;
    @Parameter(defaultValue = "${project.build.sourceDirectory}")
    private File sourceDirectory;
    @Parameter(defaultValue = "${project.basedir}")
    private File basedir;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("11111111111111111111111111111111");
        System.out.println(new File(getClass().getResource("/code-templates").getFile()).getAbsolutePath());
        String configFile = PathUtils.combine(basedir.getAbsolutePath(), "/src/main/resources", MyGeneratorProperties.DEFAULT_CONFIG_FILE_PATH);
        MyGeneratorProperties myGeneratorProperties = new MyGeneratorProperties(new File(configFile));
        try {
            Class<?> codeGeneratorClass = Class.forName(myGeneratorProperties.getImplementClass());
            CodeGenerator codeGenerator = (CodeGenerator) codeGeneratorClass.getConstructor(MyGeneratorProperties.class).newInstance(myGeneratorProperties);
            codeGenerator.setOutputPath(basedir.getAbsolutePath());
            codeGenerator.generate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
