package com.aircjm.titan.vo.request;

/**
 * @author aircjm
 */
@lombok.Data
public class TrelloWebHookReqeust {


    private Action action;
    private Model model;

    @lombok.Data
    public static class Action {

        private String id;
        private String idMemberCreator;
        private Data data;
        private String type;
        private String date;
        private MemberCreator memberCreator;


        @lombok.Data
        public static class Data {


            private Board board;
            private Card card;
            private boolean voted;

            @lombok.Data
            public static class Board {
                /**
                 * name : Trello Development
                 * id : 4d5ea62fd76aa1136000000c
                 */

                private String name;
                private String id;
            }

            @lombok.Data
            public static class Card {
                /**
                 * idShort : 1458
                 * name : Webhooks
                 * id : 51a79e72dbb7e23c7c003778
                 */

                private int idShort;
                private String name;
                private String id;

            }
        }

        @lombok.Data
        public static class MemberCreator {


            private String id;
            private String avatarHash;
            private String fullName;
            private String initials;
            private String username;
        }
    }

    @lombok.Data
    public static class Model {
        private String id;
        private String name;
        private String desc;
        private boolean closed;
        private String idOrganization;
        private boolean pinned;
        private String url;
        private Prefs prefs;
        private LabelNames labelNames;


        @lombok.Data
        public static class Prefs {


            private String permissionLevel;
            private String voting;
            private String comments;
            private String invitations;
            private boolean selfJoin;
            private boolean cardCovers;
            private boolean canBePublic;
            private boolean canBeOrg;
            private boolean canBePrivate;
            private boolean canInvite;

        }

        @lombok.Data
        public static class LabelNames {

            private String yellow;
            private String red;
            private String purple;
            private String orange;
            private String green;
            private String blue;

        }
    }
}
