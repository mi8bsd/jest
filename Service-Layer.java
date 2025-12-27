@Service
public class JailService {

    public List<JailInfo> listJails() {
        String output = CommandRunner.run("iocage list -H -o uuid,name,state");
        return Arrays.stream(output.split("\n"))
                .map(JailInfo::fromIocage)
                .toList();
    }
}
