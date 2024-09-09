import { create } from "zustand";
import { persist } from "zustand/middleware";
import axios from "axios";

const API_URL = "http://localhost:8080/silverorder/";

const useInfoStore = create(
  persist(
    (set, get) => ({
      isLogin: false,
      token: null,

      // 회원가입
      sendRegisterRequest: async (userEmail, userPassword, userBirth) => {
        const data = {
          userEmail,
          userPassword,
          userBirth,
        };
        try {
          const response = await axios.post(
            API_URL + "auth/register/general",
            data
          );
          if (response.status === 201) {
            console.log("회원가입 성공");
            return true;
          } else {
            console.log("회원가입 실패");
          }
        } catch (e) {
          return false;
        }
      },

      // 로그인
      sendLoginRequest: async (userEmail, password) => {
        const data = { userEmail, password };
        try {
          const response = await axios.post(API_URL + "auth/login", data);
          if (response.status === 200) {
            set({
              token: response.data.token,
              isLogin: true,
            });
            return true;
          } else {
            console.log("로그인 에러");
          }
        } catch (e) {
          return false;
        }
      },

      // 로그아웃
      logout: (navigate) => {
        set({ isLogin: false, token: null });
        navigate("/signin");
      },
    }),
    {
      name: "info-storage",
    }
  )
);

export default useInfoStore;
