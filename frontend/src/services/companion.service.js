import { COMPANION_TYPE } from './constants';

export const getCompanionType = (green, selectedGreen) => {
  if(selectedGreen.badCompanionsIds.includes(green.id)) {
    return COMPANION_TYPE.bad;
  } else if(selectedGreen.goodCompanionsIds.includes(green.id)) {
    return COMPANION_TYPE.good;
  } else {
    return COMPANION_TYPE.none;
  }
};
