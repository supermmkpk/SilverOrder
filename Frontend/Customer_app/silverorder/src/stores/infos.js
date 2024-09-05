import { create } from "zustand";
import { persist } from "zustand/middleware";

const useInfoStore = create(
  persist(
    (set, get) => ({
      isLogin: false,
    }),
    {
      name: "info-storage",
    }
  )
);

export default useInfoStore;
