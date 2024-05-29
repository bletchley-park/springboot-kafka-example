for name in .sts4-cache .settings .apt_generated .apt_generated_tests target; do
  for d in `find . -name "$name"`; do
    echo $d
    rm -rf $d
  done
done

for name in .DS_Store .project .classpath .factorypath .springBeans; do
  for f in `find . -type f \( -iname "$name" \)`; do
    echo $f
    rm -rf $f
  done
done


mvn clean eclipse:eclipse
