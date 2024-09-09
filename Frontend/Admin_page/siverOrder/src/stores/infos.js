import { create } from "zustand";
import { persist } from "zustand/middleware";
import axios from "axios";
import Notiflix from "notiflix";

const API_URL = "http://localhost:8080"

const useInfoStore = create(
    persist(
        (set, get) => ({
            isLogin: false,
            token: null,

            // 회원 가입
            sendRegisterRequest: async (userEmail, userPassword, userBirth) => {
                const data = {
                  userEmail,
                  userPassword,
                  userBirth,
                };
                try {
                  const response = await axios.post(
                    API_URL + "api/v1/auth/register",
                    data
                  );
                  if (response.status === 201) {
                    Notiflix.Notify.success("회원가입 성공");
                    return true;
                  } else {
                    Notiflix.Notify.failure("회원가입 실패.");
                  }
                } catch (e) {
                  return false;
                }
              },
              
              // 로그인
              sendLoginRequest: async (userEmail, userPassword) => {
                const data = { userEmail, userPassword };
                try {
                  const response = await axios.post(
                    API_URL + "api/v1/auth/login",
                    data
                  );
                  // console.log(response.data);
                  if (response.status === 200) {
                    set({
                      token: response.data.token ?? null,
                      isLogin: true,
                      userInfo: {
                        userId: response.data.userId ?? 0,
                        userEmail: response.data.userEmail ?? null,
                        userBirth: response.data.userBirth ?? null,
                        userRole: response.data.userRole ?? null,
                        userJoinDate: response.data.userJoinDate ?? null,
                        userUpdateDate: response.data.userUpdateDate ?? null,
                      },
                    });
                    return true;
                  } else {
                    Notiflix.Notify.failure("로그인 에러");
                  }
                } catch (e) {
                  return false;
                }
              },
              
              // 로그아웃
              logout: (navigate) => {
                set({ isLogin: false, token: null });
                navigate("/login");
              },

        }),
        {
            name: "info-storage",
        }
    )
);

export default useInfoStore;