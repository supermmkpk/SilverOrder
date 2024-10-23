import { create } from "zustand";
import axios from "axios";
import useInfoStore from "./infos";
import Notiflix from "notiflix";

const API_URL = 
  import.meta.env.VITE_API_BASE_URL || "http://localhost:8080/silverorder/";

const useOptionStore = create((set, get) => ({
    options: [],
    optionDetails: [],

    fetchOptions: async () => {
        const { token, userInfo } = useInfoStore.getState();

        if (!token) {
            Notiflix.Notify.failure("제대로 로그인이 되었는지 확인 부탁드립니다.");
            return;
          }

          try {
            const response = await axios.get(API_URL + `option/category/${userInfo.storeId}`, {
              headers: {
                Authorization: `Bearer ${token}`,
              },
            });
      
            const optionData = response.data.map((option) => ({
              ...option,
            }));
      
            set({ options: optionData });
          } catch (error) {
            Notiflix.Notify.failure("옵션 목록 조회에 실패했습니다.");
          }
        
    },
    createOption: async (newOption) => {
      const { token } = useInfoStore.getState();
      const { options } = get();

      if (!token) {
        Notiflix.Notify.failure("제대로 로그인이 되었는지 확인 부탁드립니다.");
        return;
      }

    // 이미 추가된 옵션인지 확인
    if (options.some((option) => option.optionCategoryTitle === newOption.optionCategoryTitle)) {
      Notiflix.Notify.failure("이미 등록된 옵션입니다.");
      return;
    }
    try {
      await axios.post(
        API_URL + `option/category`,
        newOption,
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        }
      );
      //  옵션 목록 갱신
      await get().fetchOptions();
      Notiflix.Notify.success("옵션 추가 완료");
    } catch (error) {
      Notiflix.Notify.failure("옵션 추가 실패");
    }
    },

    fetchOptionDetail: async (optionCategoryId) => {
        const { token } = useInfoStore.getState();
    
        if (!token) {
            Notiflix.Notify.failure("제대로 로그인이 되었는지 확인 부탁드립니다.");
            return;
        }
    
        try {
            const response = await axios.get(API_URL + `option/category/detail/${optionCategoryId}`, {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            });
            console.log(response.data);
            
            set({ optionDetails: response.data });
            Notiflix.Notify.success("옵션 상세 조회 완료");
        } catch (error) {
            Notiflix.Notify.failure("옵션 상세 조회에 실패했습니다.");
        }
    },

    updateOptionCategory: async (optionCategoryId, updatedOptionCategory) => {
      const { token } = useInfoStore.getState();
  
      if (!token) {
        Notiflix.Notify.failure("제대로 로그인이 되었는지 확인 부탁드립니다.");
        return;
      }
  
      try {
        await axios.patch(API_URL + `option/category/${optionCategoryId}`, updatedOptionCategory, {
          headers: {
            Authorization: `Bearer ${token}`,
            'Content-Type': 'application/json'
          }
        });
  
        Notiflix.Notify.success("옵션 카테고리 수정 완료");
        await get().fetchOptions();
      } catch (error) {
        Notiflix.Notify.failure("옵션 카테고리 수정에 실패했습니다.");
      }
    },

    deleteOption: async (optionCategoryId) => {
      const { token } = useInfoStore.getState();
  
      if (!token) {
        Notiflix.Notify.failure("제대로 로그인이 되었는지 확인 부탁드립니다.");
        return;
      }
  
      try {
        await axios.delete(API_URL + `option/category/${optionCategoryId}`, {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        });
  
        Notiflix.Notify.success("옵션 삭제 완료");
        await get().fetchOptions();  // Refresh options after deletion
      } catch (error) {
        Notiflix.Notify.failure("옵션 삭제에 실패했습니다.");
      }
    }

    
  
}));

export default useOptionStore;