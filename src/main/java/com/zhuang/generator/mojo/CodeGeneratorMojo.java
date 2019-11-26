package com.zhuang.generator.mojo;

import com.zhuang.generator.CodeGenerator;
import com.zhuang.generator.config.MyGeneratorProperties;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.util.Map;


@Mojo(name = "generate",defaultPhase = LifecyclePhase.COMPILE,requiresProject = true)
public class CodeGeneratorMojo extends AbstractMojo {


    @Parameter( defaultValue = "${project.build.directory}", property = "outputDir", required = true )
    private File outputDirectory;

    @Parameter( defaultValue = "${project.build.resources}")
    private File resources;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

        System.out.println(outputDirectory.getAbsoluteFile());

//        MyGeneratorProperties myGeneratorProperties = new MyGeneratorProperties();
//        try {
//            Class<?> codeGeneratorClass = Class.forName(myGeneratorProperties.getImplementClass());
//            CodeGenerator codeGenerator = (CodeGenerator) codeGeneratorClass.getConstructor().newInstance();
//            codeGenerator.generate();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }
}
