package profile;
import java.util.*;
import java.net.*;

public abstract class Profile {
    boolean isProfileCreated;
    boolean isItFollowed;
    boolean isPhotoAdded;

    String bio;
    String discord_chat;
    String display_name;

    int numberOfFollowers;
    int  numberOfFollowed;
    ArrayList <ViewProfile> followed;

    boolean viewLocation;
    boolean viewChallenges;
    boolean viewComments;
    boolean viewPhotos;

}
