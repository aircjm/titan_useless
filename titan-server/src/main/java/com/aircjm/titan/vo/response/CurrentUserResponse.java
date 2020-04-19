package com.aircjm.titan.vo.response;

import lombok.Data;

import java.util.List;

/**
 * @author aircjm
 */
@Data
public class CurrentUserResponse {


    private String name;
    private String avatar;
    private String userid;
    private String email;
    private String signature;
    private String title;
    private String group;
    private int notifyCount;
    private int unreadCount;
    private String country;
    private GeographicBean geographic;
    private String address;
    private String phone;
    private List<TagsBean> tags;
    private List<NoticeBean> notice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getNotifyCount() {
        return notifyCount;
    }

    public void setNotifyCount(int notifyCount) {
        this.notifyCount = notifyCount;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public GeographicBean getGeographic() {
        return geographic;
    }

    public void setGeographic(GeographicBean geographic) {
        this.geographic = geographic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public List<NoticeBean> getNotice() {
        return notice;
    }

    public void setNotice(List<NoticeBean> notice) {
        this.notice = notice;
    }

    public static class GeographicBean {
        /**
         * province : {"label":"浙江省","key":"330000"}
         * city : {"label":"杭州市","key":"330100"}
         */

        private ProvinceBean province;
        private CityBean city;

        public ProvinceBean getProvince() {
            return province;
        }

        public void setProvince(ProvinceBean province) {
            this.province = province;
        }

        public CityBean getCity() {
            return city;
        }

        public void setCity(CityBean city) {
            this.city = city;
        }

        public static class ProvinceBean {
            /**
             * label : 浙江省
             * key : 330000
             */

            private String label;
            private String key;

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }
        }

        public static class CityBean {
            /**
             * label : 杭州市
             * key : 330100
             */

            private String label;
            private String key;

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }
        }
    }

    public static class TagsBean {
        /**
         * key : 0
         * label : 很有想法的
         */

        private String key;
        private String label;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }

    public static class NoticeBean {
        /**
         * id : xxx1
         * title : Alipay
         * logo : https://gw.alipayobjects.com/zos/rmsportal/WdGqmHpayyMjiEhcKoVE.png
         * description : 那是一种内在的东西，他们到达不了，也无法触及的
         * updatedAt : 2020-04-13T04:24:25.174Z
         * member : 科学搬砖组
         * href :
         * memberLink :
         */

        private String id;
        private String title;
        private String logo;
        private String description;
        private String updatedAt;
        private String member;
        private String href;
        private String memberLink;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getMember() {
            return member;
        }

        public void setMember(String member) {
            this.member = member;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getMemberLink() {
            return memberLink;
        }

        public void setMemberLink(String memberLink) {
            this.memberLink = memberLink;
        }
    }
}
