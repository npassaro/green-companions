import { COMPANION_TYPE } from './constants';

export const getCompanionType = (green, selectedGreen) => {
  if(Object.keys(selectedGreen).length === 0){
    return COMPANION_TYPE.none;
  } else if (selectedGreen.badCompanionsIds.includes(green.id)) {
    return COMPANION_TYPE.bad;
  } else if(selectedGreen && selectedGreen.goodCompanionsIds.includes(green.id)) {
    return COMPANION_TYPE.good;
  } else {
    return COMPANION_TYPE.none;
  }
};
