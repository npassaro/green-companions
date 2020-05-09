class GoodCompanion < Green
  has_many :good_companionships, as: :companion, inverse_of: :companion, class_name: 'Companionship'
  has_many :greens, through: :good_companionships
end
