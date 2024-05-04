package sg.edu.np.mad.madpractical3;

public class User {
    String name;
    String description;
    int id;
    boolean followed;

    public User(String ip_name, String ip_desc, int ip_id, boolean ip_isFollowed) {
        name = ip_name;
        description = ip_desc;
        id = ip_id;
        followed = ip_isFollowed;
    }
}
