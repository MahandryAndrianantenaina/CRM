package itu.com.CRM.model.common;

public class Constants {

    public static class LengthConsts {
        public static final int S = 50;
        public static final int M = 255;
        public static final int L = 2000;
        public static final int XL = 4000;
    }

    public static class NameConsts {
        public static final int MIN_LENGTH = 2;
        public static final int MAX_LENGTH = LengthConsts.M;
    }

    public static class CodeConsts {
        public static final int MIN_LENGTH = 1;
        public static final int MAX_LENGTH = LengthConsts.S;
    }

    public static class DescriptionConsts {
        public static final int MAX_LENGTH = LengthConsts.XL;
    }

    public static class EmailConsts {
        public static final int MIN_LENGTH = 6;
        public static final int MAX_LENGTH = LengthConsts.M;
    }

    public static class IdConsts {
        public static final int MAX_LENGTH = LengthConsts.S;
    }

    public static class PasswordConsts {
        public static final int MIN_LENGTH = 6;
        public static final int MAX_LENGTH = LengthConsts.M;
    }

    public static class PathConsts {
        public static final int MAX_LENGTH = LengthConsts.M;
    }

    public static class TokenConsts {
        public static final int MAX_LENGTH = LengthConsts.XL;
        public static final double EXPIRY_IN_DAYS = 30;
    }

    public static class UserIdConsts {
        public static final int MAX_LENGTH = 450;
    }
}
