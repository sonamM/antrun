call mvn install:install-file -Dfile="mobile-webdriver.jar" -DgroupId="com.experitest.selenium" -DartifactId="mobile-webdriver" -Dversion="1.0" -Dpackaging="jar"

call mvn install:install-file -Dfile="imageClient.jar" -DgroupId="com.experitest.client" -DartifactId="imageClient" -Dversion="1.0" -Dpackaging="jar"

call mvn install:install-file -Dfile="MonteScreenRecorder.jar" -DgroupId="org.monte" -DartifactId="MonteScreenRecorder" -Dversion="0.7.5" -Dpackaging=jar

call mvn install:install-file -Dfile="sqljdbc4-2.0.jar" -DgroupId="com.microsoft.sqlserver" -DartifactId="sqljdbc" -Dversion="4-2.0" -Dpackaging="jar"

call mvn install:install-file -Dfile="com.microsoft.tfs.sdk-11.0.0.jar" -DgroupId="com.microsoft.tfs.sdk" -DartifactId="com.microsoft.tfs.sdk" -Dversion="11.0.0" -Dpackaging="jar"

echo "Files installed"

